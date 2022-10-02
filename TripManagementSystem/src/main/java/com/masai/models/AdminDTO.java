package com.masai.models;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
//	@NotNull(message = "Mobile is mandatory")
	private String mobile;
	
	
//	@NotNull(message = "Password is mandatory")
	private String password;
}
