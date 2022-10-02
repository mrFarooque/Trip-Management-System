package com.masai.models;

import lombok.Data;

@Data
public class AdminSigninDTO {
	private String adminName;
	private String email;
	private String mobile;
	
	private String password;
}
