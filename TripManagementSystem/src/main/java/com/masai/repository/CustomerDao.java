package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
