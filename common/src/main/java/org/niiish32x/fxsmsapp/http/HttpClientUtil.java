package org.niiish32x.fxsmsapp.http;

import com.google.common.base.Throwables;
import org.apache.hc.client5.http.ConnectTimeoutException;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.classic.HttpRequestRetryExec;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.LayeredConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.NoHttpResponseException;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * HttpClientUtil
 *
 * @author shenghao ni
 * @date 2024.12.04 23:02
 */
public class HttpClientUtil {
    private static final int MAX_TIMEOUT = 400;
    private static final CloseableHttpClient httpClient;

    static {
        // 自定义 SSL 策略
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", createSSLConnSocketFactory())
                .build();
        // 设置连接池
        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(registry);
        connMgr.setMaxTotal(100); // 设置连接池大小
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal()); // 设置每条路由的最大并发连接数
        connMgr.setValidateAfterInactivity(TimeValue.ofSeconds(600)); // 设置长连接

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofMilliseconds(MAX_TIMEOUT))                   // 建立连接超时时间
                .setResponseTimeout(Timeout.ofSeconds(MAX_TIMEOUT))                    // 传输超时
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(MAX_TIMEOUT))         // 设置从连接池获取连接实例的超时
                .build();

        httpClient = HttpClients.custom()
                .setConnectionManager(connMgr)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setRetryStrategy(new DefaultHttpRequestRetryStrategy())  // 重试 1 次，间隔1s
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    public static byte[] doGet(String url) throws IOException, ParseException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
//            int statusCode = response.getStatusLine().getStatusCode();
            int statusCode = response.getCode();
            if (statusCode != HttpStatus.SC_OK) {
                String message = EntityUtils.toString(response.getEntity());
                throw new HttpResponseException(statusCode, message);
            }
            byte[] bytes = EntityUtils.toByteArray(response.getEntity());
            return bytes;
        } catch (Exception e) {
            throw e;
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                }
            }
        }
    }

    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;    // 信任所有证书
                }
            });
        } catch (GeneralSecurityException e) {
            throw Throwables.propagate(e);
        }
        return sslsf;
    }
}

