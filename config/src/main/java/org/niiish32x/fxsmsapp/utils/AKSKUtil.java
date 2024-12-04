package org.niiish32x.fxsmsapp.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * AKSKUtil
 *
 * @author shenghao ni
 * @date 2024.12.04 11:30
 */
@Slf4j
public class AKSKUtil {
    public static String signature(String sk, String method, String uri, String contentType, String queryString, String customHeaders, String requestBodyPayload) {

        String requestString = new StringBuilder()
                .append(method).append("\n")
                .append(uri).append("\n")
                .append(contentType).append("\n")
                .append(queryString).append("\n")
                .append(customHeaders).append("\n")
                .append(requestBodyPayload).toString();

        log.info("sk: {}, requestString: {}", sk, requestString);
        return HmacUtil.hmacSha256(sk, requestString);
    }
}
