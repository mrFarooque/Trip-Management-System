package com.masai.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	private String reportName;
	private String reportType;
}
