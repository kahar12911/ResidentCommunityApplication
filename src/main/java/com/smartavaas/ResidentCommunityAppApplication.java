package com.smartavaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ResidentCommunityAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResidentCommunityAppApplication.class, args);
        System.out.println("success");
    }

}
