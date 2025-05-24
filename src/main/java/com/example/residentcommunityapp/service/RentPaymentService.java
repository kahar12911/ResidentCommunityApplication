package com.example.residentcommunityapp.service;

import com.example.residentcommunityapp.dto.RentPaymentRequest;
import com.example.residentcommunityapp.dto.RentPaymentResponse;
import com.example.residentcommunityapp.mapper.RentPaymentMapper;
import com.example.residentcommunityapp.model.RentPayment;
import com.example.residentcommunityapp.model.User;
import com.example.residentcommunityapp.payment.PaymentGatewayFactory;
import com.example.residentcommunityapp.repository.RentPaymentRepository;
import com.example.residentcommunityapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentPaymentService {

    private final RentPaymentRepository rentPaymentRepo;
    private final UserRepository userRepository;
    private final PaymentGatewayFactory gatewayFactory;

    public List<RentPaymentResponse> getPaymentsForUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return rentPaymentRepo.findByUser(user)
                .stream()
                .map(RentPaymentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public RentPaymentResponse payRent(RentPaymentRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Choose gateway based on mode
        String transactionId = gatewayFactory
                .getGateway(request.getMode())
                .processPayment(user, request);

        RentPayment payment = new RentPayment();
        payment.setUser(user);
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("PAID");
        payment.setMode(request.getMode());
        payment.setAutoPayEnabled(request.isAutoPayEnabled());
        payment.setInvoiceUrl("https://example.com/invoice/" + transactionId);
        payment.setReceiptUrl("https://example.com/receipt/" + transactionId);

        rentPaymentRepo.save(payment);

        return RentPaymentMapper.toResponse(payment);
    }
}