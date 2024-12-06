package org.niiish32x.fxsmsapp.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * AppConfig
 *
 * @author shenghao ni
 * @date 2024.12.06 10:42
 */
@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppConfig {

    /**
     * supOS地址
     */
//    @Value("${supos.supos-address}")
    private String suposWebAddress;

    /**
     * supOS appId
     */
//    @Value("${supos.app-id}")
    private String appId;

    /**
     * supOS appSecret
     */
//    @Value("${supos.app-secret}")
    private String appSecret;
}
