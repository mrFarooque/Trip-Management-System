package com.masai.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hotel bookedHotel;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PaymentDetails> paymentDetails = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Hotel> hotels = new ArrayList<>();
	
		
	@OneToOne(cascade = CascadeType.ALL)
	private TicketDetails ticketDetail;
}
