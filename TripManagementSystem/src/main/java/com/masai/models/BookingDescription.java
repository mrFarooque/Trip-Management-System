package com.masai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDescription {
	private Double hotelCost;
	private Double travelCost;
	private Double gst;
	private Double packageCost;
	private Double totalCost;
	private String description;
}
