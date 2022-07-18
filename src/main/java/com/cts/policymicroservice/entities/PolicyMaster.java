package com.cts.policymicroservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class PolicyMaster {

	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String popertyType;
	
	private String consumerType;
	
	private int assuredSumTenure;
	
	private long businesValue;
	
	private long propertyValue;
	
	private String baseLocation;
	
	private String type;
	
}
