package com.daonq1408.springbootsetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daonq1408.springbootsetup.config.DotEnvConfig;

@SpringBootApplication
public class SpringBootSetupApplication {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(SpringBootSetupApplication.class, args);
    }
}
