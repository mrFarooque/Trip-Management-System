package com.masai.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private String paymentType;
	private LocalDate paymentTime;
	
	
}
