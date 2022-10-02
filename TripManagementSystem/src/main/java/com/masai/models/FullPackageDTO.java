package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullPackageDTO {
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
	
	private List<Hotel> hotels = new ArrayList<>();
		
	private TicketDetails ticketDetail;
}
