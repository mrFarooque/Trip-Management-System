
package com.masai.models;

import lombok.Data;

@Data
public class CustomerSigninDTO {
	private String customerName;
	private String email;
	private String address;
	private String mobile;
	private String password;

}
