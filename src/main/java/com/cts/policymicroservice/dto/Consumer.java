package com.cts.policymicroservice.dto;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.aspectj.weaver.loadtime.Agent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Consumer {

	@Id
	@GeneratedValue
	private int consumer_id;

	private String name;

	private String type;
	
	private Date validity;
	
	private Date DOB;

	private String email;

	private String PAN;

	@Embedded
	private Business business;

	@Embedded
	private Agent agent;


}
