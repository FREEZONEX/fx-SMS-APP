package org.niiish32x.fxsmsapp.runner;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Configs
 *
 * @author shenghao ni
 * @date 2024.12.04 15:43
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Configs {

    private long code;
    private Data data;
    private String message;

    @NoArgsConstructor
    @lombok.Data
    @Accessors(chain = true)
    public static class Data {

        private List<Config> config;

    }

    @NoArgsConstructor
    @lombok.Data
    @Accessors(chain = true)
    public static class Config {

        private String code;
        private long configId;
        private String name;
        private List<String> value;

    }
}
