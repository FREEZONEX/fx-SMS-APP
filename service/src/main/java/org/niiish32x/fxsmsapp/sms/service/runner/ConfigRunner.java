package org.niiish32x.fxsmsapp.sms.service.runner;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.tuple.Triple;
import org.niiish32x.fxsmsapp.config.SuposConfiguration;
import org.niiish32x.fxsmsapp.config.client.SuposClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * ConfigRunner
 *
 * 初始化系统配置
 *
 * @author shenghao ni
 * @date 2024.12.04 15:36
 */
@Component
@Slf4j
@Order(value = 1)
public class ConfigRunner implements CommandLineRunner {

    @Autowired
    private SuposClient suposClint;
    @Autowired
    SuposConfiguration suposConfiguration;

    static final String appcode = "supostwilio";
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    String TOKEN = "TWILIO_AUTH_TOKEN";
    String SID = "TWILIO_ACCOUNT_SID";

    String MOBILE = "TWILIO_SEND_MOBILE";
    String TEST = "TWILIO_TEST";

    @Override
    public void run(String... args) throws Exception {


        String request = JSONObject.toJSONString(new ConfigDto().setType(2)
                .setCatalogs(Arrays.asList(new ConfigDto.Catalog()
                        .setAppCode(suposConfiguration.getAppId())
                        .setName("SMS")
                        .setOrder("1")
                        .setCode(appcode)
                        .setConfig(Arrays.asList(
                                        new ConfigDto.Config()
                                                .setCode(SID)
                                                .setName("AccountSid")
                                                .setType("0")
                                                .setOrder("1")

                                                .setTypeConfig(new ConfigDto.TypeConfig().setRemind(""))
                                                .setVerify(Arrays.asList(new ConfigDto.Verify().setRequire(true)
                                                        .setMax(100)

                                                )),
                                        new ConfigDto.Config()
                                                .setCode(TOKEN)
                                                .setName("AuthToken")
                                                .setType("0")

                                                .setOrder("2")
                                                .setTypeConfig(new ConfigDto.TypeConfig().setRemind(""))
                                                .setVerify(Arrays.asList(new ConfigDto.Verify().setRequire(true)
                                                        .setMax(100)

                                                )),
                                        new ConfigDto.Config()
                                                .setCode(MOBILE)
                                                .setName("Sender Phone")
                                                .setType("0")
                                                .setOrder("3")
                                                .setTypeConfig(new ConfigDto.TypeConfig().setRemind(""))
                                                .setVerify(Arrays.asList(new ConfigDto.Verify().setRequire(true)
                                                        .setMax(100)

                                                )),
                                        new ConfigDto.Config()
                                                .setCode(TEST)
                                                .setName(TEST)
                                                .setType("9")
                                                .setOrder("4")
                                                .setTypeConfig(new ConfigDto.TypeConfig().setRemind("notificationAdmin.SMSConnectTest")
                                                        .setOptionalValue(Arrays.asList(new OptionalValue("url", "/inter-api/notification-admin/v1/notice/sms", 0.d, false),
                                                                new OptionalValue("method", "POST", 0.d, false)))
                                                )
                                )

                        ))));


        try {
            suposClint.addSystemConfig(request);
        } catch (Exception e) {
            log.error("{}", ExceptionUtils.getStackTrace(e));
        }

        log.info("-----初始化系统配置完成-----");

    }

    public Triple<String, String, String> getSmsConfig() {
        try {
            String systemConfig = suposClint.getSystemConfig(suposConfiguration.getAppId());
            log.info("supos client << {} ", systemConfig);
            Configs configs = JSONObject.parseObject(systemConfig, Configs.class);

            if (Objects.equals(configs.getCode(), 100000000L)) {

                List<Configs.Config> config = Optional.ofNullable(configs.getData().getConfig()).orElse(Collections.emptyList());
                String sid = config.stream().filter(x -> x.getCode().equals(SID)).map(x -> x.getValue().stream().findAny().orElse("")).findAny().orElse("");
                String token = config.stream().filter(x -> x.getCode().equals(TOKEN)).map(x -> x.getValue().stream().findAny().orElse("")).findAny().orElse("");
                String mobile = config.stream().filter(x -> x.getCode().equals(MOBILE)).map(x -> x.getValue().stream().findAny().orElse("")).findAny().orElse("");


                Triple<String, String, String> configT3 = Triple.of(sid, token, mobile);
                log.info("config= {}", configT3);
                return configT3;
            }

        } catch (Exception e) {
            log.error("{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }


    @Data
    @Accessors(chain = true)
    @SuppressWarnings("unused")
    static class ConfigDto {

        private List<Catalog> catalogs;
        private long type;

        @Data
        @Accessors(chain = true)
        @SuppressWarnings("unused")
        public static class Config {

            private String code;
            private List<String> defaultValue;
            private String name;
            private String order;
            private String type;
            private TypeConfig typeConfig;
            private List<Verify> verify;
        }

        @Data
        @Accessors(chain = true)
        @SuppressWarnings("unused")
        public static class Catalog {

            private String appCode;
            private String code;
            private List<Config> config;
            private String name;
            private String order;
        }

        @Data
        @Accessors(chain = true)
        @SuppressWarnings("unused")
        public static class TypeConfig {

            private String remind;

            @Valid
            private List<OptionalValue> optionalValue;

        }

        @Data
        @Accessors(chain = true)
        @SuppressWarnings("unused")
        public static class Verify {

            @JSONField(name = "isRequire")
            @JsonProperty("isRequire")
            private boolean isRequire;
            private Integer max;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Valid
    public static class OptionalValue {

        @NotEmpty()
        private String label;

        @NotEmpty()
        private String value;

        @NotNull()
        private Double order;

        private Boolean isDelete;
    }

}

