package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Customer;
import com.masai.models.LoginData;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByMobile(String mobile);
}
