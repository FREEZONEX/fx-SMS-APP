package org.niiish32x.fxsmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bootstrap
 *
 * @author shenghao ni
 * @date 2024.12.05 16:59
 */
@SpringBootApplication(scanBasePackages = "org.niiish32x.fxsmsapp")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class,args);

    }
}
