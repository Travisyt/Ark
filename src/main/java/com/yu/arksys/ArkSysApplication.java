package com.yu.arksys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArkSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArkSysApplication.class, args);
    }

}
