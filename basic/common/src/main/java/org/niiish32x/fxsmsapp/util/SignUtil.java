package org.niiish32x.fxsmsapp.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * SignUtil
 *
 * @author shenghao ni
 * @date 2024.12.05 19:59
 */
public class SignUtil {
    private static final String CARRIAGE_RETURN = "\n";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String EMPTY_STR = "";
    /**
     * 请求header签名
     *
     * @param uri        open-api的uri
     * @param methodName 请求方法名(字母大写)：GET POST DELETE PUT
     * @param headerMap  请求头参数
     * @param queryMap   请求参数（url ？后的参数）
     */
    public static void signHeader(String uri, String methodName, Map<String, String> headerMap, Map<String, Object> queryMap) {
        StringBuffer sb = buildSignSource(uri, methodName, headerMap, queryMap).append(CARRIAGE_RETURN);
        System.out.println("签名源内容：\n" + sb);
        HmacUtils hmacSha256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, SdkConfig.sk);
        String signature = hmacSha256.hmacHex(sb.toString());
        String finalSignature = "Sign " + SdkConfig.ak + "-" + signature;
        System.out.println("签名结果：\n" + finalSignature);
        headerMap.put("Authorization", finalSignature);
    }

    /**
     * 拼接签名源
     *
     * @param uri        open-api的uri
     * @param methodName 请求方法名(字母大写)：GET POST DELETE PUT
     * @param headerMap  请求头参数
     * @param queryMap   请求参数（url ？后的参数）
     * @return 签名源串
     */
    private static StringBuffer buildSignSource(String uri, String methodName, Map<String, String> headerMap, Map<String, Object> queryMap) {
        StringBuffer signStr = new StringBuffer();
        assert StringUtils.isNotBlank(methodName);
        //HTTP Schema
        signStr.append(methodName.toUpperCase(Locale.ROOT)).append(CARRIAGE_RETURN);
        assert StringUtils.isNotBlank(uri);
        //HTTP URI
        signStr.append(uri).append(CARRIAGE_RETURN);
        String contentType = headerMap.getOrDefault(CONTENT_TYPE, "application/json");
        assert StringUtils.isNotBlank(contentType);
        //HTTP ContentType
        signStr.append(contentType).append(CARRIAGE_RETURN);
        //CanonicalQueryString
        signStr.append(buildCanonicalQueryString(queryMap)).append(CARRIAGE_RETURN).append(CARRIAGE_RETURN);
        return signStr;
    }

    /**
     * 生成有序的查询参数串
     *
     * @param queryMap 查询参数
     * @return 有序的查询参数串
     */
    private static String buildCanonicalQueryString(Map<String, Object> queryMap) {
        TreeMap<String, Object> queryTreeMap = new TreeMap<>();
        if (queryMap != null && queryMap.size() > 0) {
            for (Map.Entry<String, Object> m : queryMap.entrySet()) {
                queryTreeMap.put(m.getKey().toLowerCase(Locale.ROOT), m.getValue());
            }
            return queryTreeMap.toString().replace("{", EMPTY_STR)
                    .replace("}", EMPTY_STR).replace(", ", "&");
        }
        return EMPTY_STR;
    }
}