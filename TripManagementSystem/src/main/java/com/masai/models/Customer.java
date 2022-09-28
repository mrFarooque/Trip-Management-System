package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
	
	private String customerName;
	private String email;
	private String address;
	private String mobile;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Feedback> feedbacks = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	
}
