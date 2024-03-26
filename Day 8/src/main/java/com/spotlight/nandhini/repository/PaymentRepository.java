package com.spotlight.nandhini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spotlight.nandhini.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    
}
