package org.niiish32x.fxsmsapp.sms.service.runner;

import feign.RequestInterceptor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.niiish32x.fxsmsapp.config.SuposConfiguration;
import org.niiish32x.fxsmsapp.config.utils.AKSKUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

import static org.niiish32x.fxsmsapp.config.Constants.HTTP_HEADER_AUTHORIZATION;

/**
 * ClientConfiguration
 *
 * @author shenghao ni
 * @date 2024.12.04 15:34
 */
@Configuration
@Slf4j
public class ClientConfiguration {


    @Autowired
    SuposConfiguration suposConfiguration;

    @Value("${SUPOS_APP_TENANT_ID:dt}")
    String SUPOS_APP_TENANT_ID;

    @Bean
    public RequestInterceptor headerInterceptor() {
        return template -> {
            String url = template.url();
            String method = template.method();
            String ContentType = template.headers().get("Content-Type").stream().findAny().orElse("");
            Map<String, Collection<String>> queries = template.queries();
            String signature = AKSKUtil.signature(
                    suposConfiguration.getSk(),
                    method,
                    url,
                    ContentType,
                    getCanonicalQueryString(template.queries()),
                    getCanonicalCustomHeaders(template.headers())
                    , ""
            );

            String authorization = "Sign " + suposConfiguration.getAk() + "-" + signature;
            Map<String, Collection<String>> headers = new HashMap<>();
            headers.put(HTTP_HEADER_AUTHORIZATION, Arrays.asList(authorization));
            headers.put("X-Tenant-Id", Arrays.asList(SUPOS_APP_TENANT_ID));

            template.headers(headers);

        };
    }


    private String getCanonicalQueryString(Map<String, Collection<String>> queryParams) {

        final Map<String, String> params = new TreeMap<>();
        for (Map.Entry<String, Collection<String>> entry : queryParams.entrySet()) {
            String key = entry.getKey().toLowerCase();
            entry.getValue().stream().findAny().ifPresent(x -> {
                params.put(key, x);
            });

        }
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key).append("=").append(params.get(key));
        }
        return sb.toString();
    }

    private String getCanonicalCustomHeaders(Map<String, Collection<String>> headers) {

        if (headers.isEmpty()) {
            return "";
        }
        Map<String, String> params = new TreeMap<>();
        for (Map.Entry<String, Collection<String>> entry : headers.entrySet()) {
            String key = entry.getKey().toLowerCase();
            if (key.startsWith("x-mc-")) {
                entry.getValue().stream().findAny().ifPresent(x -> {
                    params.put(key, x);
                });

            }
        }
        StringBuilder sb = new StringBuilder();
        for (String key : params.keySet()) {
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append(key).append(":").append(params.get(key));
        }
        return sb.toString();
    }

}
