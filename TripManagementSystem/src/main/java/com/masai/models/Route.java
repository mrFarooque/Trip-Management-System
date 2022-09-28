package com.masai.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer routeId;
	private String routeFrom;
	private String routeTo;
	private LocalDate departureTime;
	private LocalDate arrivalTime;
	private LocalDate doj;
	private String pickupPoint;
	private Double Fare;
	
	@OneToMany(cascade =  CascadeType.ALL)
	private List<Bus> busList = new ArrayList<>();
	
	@OneToMany(cascade =  CascadeType.ALL)
	private List<TicketDetails> ticketDetailsList = new ArrayList<>();
	

	
}
