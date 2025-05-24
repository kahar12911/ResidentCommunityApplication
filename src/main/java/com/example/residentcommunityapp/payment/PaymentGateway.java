package com.example.residentcommunityapp.payment;

import com.example.residentcommunityapp.dto.RentPaymentRequest;
import com.example.residentcommunityapp.model.User;

public interface PaymentGateway {
    String processPayment(User user, RentPaymentRequest request);
}
