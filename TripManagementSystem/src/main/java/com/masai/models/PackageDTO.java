package com.masai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDTO {
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
}
