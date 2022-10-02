package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
//	@NotNull(message = "Name is mandatory")
	private String adminName;
	
//	@Email(message="Enter your Email properly")
//	@NotNull(message = "Email is mandatory")
	private String email;
	
//	@Column(unique = true)
//	@Size(max = 10,min = 10)
//	@NotNull(message = "Mobile is mandatory")
	private String mobile;
	
	private String userType="admin";
	
//	@NotNull(message = "Password is mandatory")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Report> reports = new ArrayList<>();
	
}
