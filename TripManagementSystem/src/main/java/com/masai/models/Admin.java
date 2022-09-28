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
public class Admin extends User{
	
	
	private String adminName;
	private String email;
	private String mobile;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Report> reports = new ArrayList<>();
	
}
