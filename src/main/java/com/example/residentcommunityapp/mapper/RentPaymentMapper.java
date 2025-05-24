package com.example.residentcommunityapp.mapper;

import com.example.residentcommunityapp.dto.RentPaymentResponse;
import com.example.residentcommunityapp.model.RentPayment;

public class RentPaymentMapper {
    public static RentPaymentResponse toResponse(RentPayment payment) {
        RentPaymentResponse res = new RentPaymentResponse();
        res.setId(payment.getId());
        res.setAmount(payment.getAmount());
        res.setPaymentDate(payment.getPaymentDate());
        res.setStatus(payment.getStatus());
        res.setMode(payment.getMode());
        res.setInvoiceUrl(payment.getInvoiceUrl());
        res.setReceiptUrl(payment.getReceiptUrl());
        return res;
    }
}
