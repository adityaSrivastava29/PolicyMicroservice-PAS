package com.cts.policymicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.policymicroservice.Clients.FeignServiceUtil;
import com.cts.policymicroservice.Clients.QuotesClient;
import com.cts.policymicroservice.dto.Consumer;
import com.cts.policymicroservice.entities.ConsumerPolicy;
import com.cts.policymicroservice.helpers.APIResponse;
import com.cts.policymicroservice.service.ConsumerPolicyServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/policy")
public class policyController {

	@Autowired
	ConsumerPolicyServiceImpl consumerPolicyServiceImpl;

	@Autowired
	FeignServiceUtil feignServiceUtil;

	@Autowired
	QuotesClient quotesClient;

	@GetMapping("/getAll")
	public List<ConsumerPolicy> getAll() {
		return consumerPolicyServiceImpl.findAll();
	}
	
	
	@GetMapping("/getPolicy/{id}")
	public ResponseEntity<?> getPolicy(@PathVariable int id){
		log.info("Start get Policy inside Policy Controller");
		  APIResponse response  = new APIResponse();
		  
		  ConsumerPolicy policy = consumerPolicyServiceImpl.getPolicy(id);
		  
		   if(policy == null) {
			   response.setMessage("Policy Not Found");
			   log.debug("Token is invalid.");
			   return ResponseEntity.ok(response);
		   }
		   log.info("End get Policy inside Policy Controller");
		   return ResponseEntity.ok(policy);
		
	}
	  
	@PostMapping("/createPolicy")
	public ResponseEntity<?> createPolicy(@RequestBody ConsumerPolicy consumerPolicy) {
		log.info("Start Create Policy inside Policy Controller");
		APIResponse response  = new APIResponse();

		String message = consumerPolicyServiceImpl.saveToRepo(consumerPolicy);
		log.info("Created Policy: {}", message);
		response.setMessage(message);
		log.info("End Create Policy inside Policy Controller");
		return ResponseEntity.ok(response);

	}

	@PostMapping("/issuePolicy")
	public ResponseEntity<?> issuePolicy(@RequestBody ConsumerPolicy consumerPolicy) {
		log.info("Start Issue Policy inside Policy Controller");
		APIResponse response  = new APIResponse();
		String message = consumerPolicyServiceImpl.issuePolicy(consumerPolicy);
		response.setMessage(message);
		log.info("End Issue Policy inside Policy Controller");
		return ResponseEntity.ok(response);

	}

	@GetMapping("/qh")
	public String geth() {
		return quotesClient.getHealthQuote();
	}

	@GetMapping("/testconnectiontoConsumerviaPolicy")
	public String testC() {
		return feignServiceUtil.getHealthConsumer();

	}

	@GetMapping("/getConsumer/{id}")
	public Consumer getConsumer(@PathVariable int id) {
		log.info(" get Consumer ID inside Policy Controller");
		return feignServiceUtil.viewConsumerBusiness(id);
	}

}
