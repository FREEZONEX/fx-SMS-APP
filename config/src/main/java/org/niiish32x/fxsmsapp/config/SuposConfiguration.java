package org.niiish32x.fxsmsapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SuposConfiguration
 * 参考 https://docs.emqx.com/zh/fabric/latest/api_auth/ak_sk.html#%E7%AE%A1%E7%90%86ak-sk
 * ak sk 鉴权
 * @author shenghao ni
 * @date 2024.12.04 11:26
 *
 */
@Component
@ConfigurationProperties(
        prefix = "supfusion.supos"
)
@Data
public class SuposConfiguration {
    private String ak;
    private String sk;
    private String suposHost;
    private String appId;
}
