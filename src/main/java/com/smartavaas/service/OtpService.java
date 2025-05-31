package com.smartavaas.service;

import com.smartavaas.config.Fast2SmsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OtpService {

    @Autowired
    private Fast2SmsProperties properties;

    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();

    public String generateOtp(String mobile) {
        String otp = String.valueOf(new Random().nextInt(899999) + 100000);
        otpStorage.put(mobile, otp);
        return otp;
    }

    public boolean validateOtp(String mobile, String otp) {
        return otp.equals(otpStorage.get(mobile));
    }

    public void sendOtp(String mobile, String otp) {
        try {
            String url = "https://www.fast2sms.com/dev/bulkV2";

            HttpHeaders headers = new HttpHeaders();
            headers.set("authorization", properties.getApiKey());
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("variables_values", otp);
            body.add("route", properties.getRoute());
            body.add("numbers", mobile);
            body.add("sender_id", properties.getSender());

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            System.out.println("SMS Response: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
