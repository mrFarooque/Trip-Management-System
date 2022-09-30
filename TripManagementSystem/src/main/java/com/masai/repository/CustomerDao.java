package com.masai.repository;

<<<<<<< HEAD
=======
import java.util.Optional;

>>>>>>> 0d5e947b810b79c265e67079664154fd4e2f1a24
import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Customer;

<<<<<<< HEAD
public interface CustomerDao extends JpaRepository<Customer, Integer> {

=======


public interface CustomerDao extends JpaRepository<Customer,Integer>{
	public Optional<Customer> findByMobileNo(String string);
>>>>>>> 0d5e947b810b79c265e67079664154fd4e2f1a24
}
