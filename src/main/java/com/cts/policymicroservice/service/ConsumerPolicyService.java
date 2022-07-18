package com.cts.policymicroservice.service;

import java.util.List;

import com.cts.policymicroservice.entities.ConsumerPolicy;

public interface ConsumerPolicyService {

	public String saveToRepo(ConsumerPolicy consumerPolicy);
	
	public List<ConsumerPolicy> findAll();
	
	public String issuePolicy(ConsumerPolicy consumerPolicy);
	
	
}
