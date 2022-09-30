package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.PaymentDetails;

public interface PaymentDetailsDao extends JpaRepository<PaymentDetails, Integer> {

}
