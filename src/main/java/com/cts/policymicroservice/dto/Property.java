package com.cts.policymicroservice.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

	
	@Id
	@GeneratedValue
	private int property_id;

	private String buisness_id;	
	private int consumer_id;
	private long building_sq_ft;
	private  String building_type;
	private String building_storeys;
	private int building_age;
	
	
}
