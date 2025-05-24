package com.example.residentcommunityapp.payment;

import com.example.residentcommunityapp.dto.RentPaymentRequest;
import com.example.residentcommunityapp.model.User;
import org.springframework.stereotype.Component;

@Component("UPI")
public class UpiPaymentGateway implements PaymentGateway {
    @Override
    public String processPayment(User user, RentPaymentRequest request) {
        // Simulate UPI payment gateway logic
        return "UPI_TXN_" + System.currentTimeMillis();
    }
}