package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Integer userId;
	private String userType;
	private String password;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Booking> bookingList = new ArrayList<>();
//	
//	@OneToMany(cascade =  CascadeType.ALL)
//	private List<Route> routeList = new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Travels> travelsList= new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	List<Bus> busList = new ArrayList<>();
	
}
