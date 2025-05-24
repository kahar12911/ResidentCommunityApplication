package com.example.residentcommunityapp.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentGatewayFactory {
    private final ApplicationContext context;

    public PaymentGateway getGateway(String mode) {
        return context.getBean(mode.toUpperCase(), PaymentGateway.class);
    }
}
