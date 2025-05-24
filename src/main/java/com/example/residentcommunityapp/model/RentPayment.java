package com.example.residentcommunityapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class RentPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    private Double amount;
    private LocalDate paymentDate;
    private String status;
    private String mode;
    private boolean autoPayEnabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String invoiceUrl;
    private String receiptUrl;
}