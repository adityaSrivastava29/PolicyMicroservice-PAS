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
public class ConsumerPolicy {

	@Id
	@GeneratedValue
	private int policyId;

//	@NotNull
	private int consumerid;

//	@NotNull
	private int propertyid;

	private int propertyValue;

//	@NotNull
	private String businessId;

	private String assuredSum;

	private String agent_id;

	private String policyStatus;

	private int businessValue;
	
	public String paymentStatus;
	
	public String acceptanceStatus;
	
	private String consumerType = "Owner";
	
	private String propertyType = "Building";
	
	private String tenure = "3 years";
	
	private String type = "Replacement";

}
