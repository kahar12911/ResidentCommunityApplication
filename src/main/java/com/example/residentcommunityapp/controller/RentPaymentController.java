package com.example.residentcommunityapp.controller;

import com.example.residentcommunityapp.dto.RentPaymentRequest;
import com.example.residentcommunityapp.dto.RentPaymentResponse;
import com.example.residentcommunityapp.service.RentPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
@RequiredArgsConstructor
public class RentPaymentController {

    private final RentPaymentService rentPaymentService;

    @GetMapping("/my-payments")
    public ResponseEntity<List<RentPaymentResponse>> getMyPayments(Authentication auth) {
        String email = auth.getName();
        return ResponseEntity.ok(rentPaymentService.getPaymentsForUser(email));
    }

    @PostMapping("/pay")
    public ResponseEntity<RentPaymentResponse> makePayment(@RequestBody RentPaymentRequest request, Authentication auth) {
        String email = auth.getName();
        return ResponseEntity.ok(rentPaymentService.payRent(request, email));
    }
}