package com.cts.policymicroservice.dto;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Business {

	
	private String businessId;
	private String businessType;
	private Long businessAge;
	private Long capitalInvested;
	private Long annualTurnover;
	private int totalEmployees;

}
