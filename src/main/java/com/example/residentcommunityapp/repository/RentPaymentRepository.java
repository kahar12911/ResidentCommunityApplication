package com.example.residentcommunityapp.repository;

import com.example.residentcommunityapp.model.RentPayment;
import com.example.residentcommunityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentPaymentRepository extends JpaRepository<RentPayment, Long> {
    List<RentPayment> findByUser(User user);
}