package org.niiish32x.fxsmsapp.dao.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * DaoConfiguration
 *
 * @author shenghao ni
 * @date 2024.12.05 14:33
 */

@Configuration
@ComponentScan(
        basePackages = {
                "org.niiish32x.fxsmsapp.**.persistence",
                "org.niiish32x.fxsmsapp.dao.configuration",
                "org.niiish32x.fxsmsapp.**.repo"
        }
)
public class PersistenceTestConfiguration {
}
