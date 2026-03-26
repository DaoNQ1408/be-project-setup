package com.daonq.springbootsetupv2;

import com.daonq.springbootsetupv2.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSetupV2Application {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(SpringBootSetupV2Application.class, args);
    }

}
