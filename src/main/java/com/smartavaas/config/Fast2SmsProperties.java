package com.smartavaas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "fast2sms")
@Data
public class Fast2SmsProperties {
    private String apiKey;
    private String route;
    private String sender;
    private String country;
}
