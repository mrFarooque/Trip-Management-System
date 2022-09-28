package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.SignUp;

@Repository
public interface SignUpDAO extends JpaRepository<SignUp,Integer> {
	
	public Optional<SignUp> findByUserName(String userName);

}
