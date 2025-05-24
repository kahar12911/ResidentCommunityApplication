package com.example.residentcommunityapp.payment;

import com.example.residentcommunityapp.dto.RentPaymentRequest;
import com.example.residentcommunityapp.model.User;
import org.springframework.stereotype.Component;

@Component("PAYPAL")
public class PaypalPaymentGateway implements PaymentGateway {
    @Override
    public String processPayment(User user, RentPaymentRequest request) {
        // Logic to integrate PayPal payment
        return "PAYPAL_TXN_" + System.currentTimeMillis();
    }
}