package com.cts.policymicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.policymicroservice.entities.ConsumerPolicy;

@Repository
public interface ConsumerPolicyRepository extends JpaRepository<ConsumerPolicy, Integer>{

	public List<ConsumerPolicy> findByConsumerid(int consumerid);
	
	public List<ConsumerPolicy> findByPropertyid(int property_id);

}
