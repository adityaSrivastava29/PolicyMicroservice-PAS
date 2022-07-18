package com.cts.policymicroservice.Clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.policymicroservice.dto.Consumer;

@FeignClient(value="feignDemo", url="http://localhost:9002/consumermicroservice" )


public interface FeignServiceUtil {

		@GetMapping("/HealthCheck")
		String getHealthConsumer();
		
		@GetMapping("/viewConsumerBusiness/{id}")
		public Consumer viewConsumerBusiness(@PathVariable int id);
		
		@GetMapping("/getQuotes/{id}")
		public String getQuotes( @PathVariable int id);
		
	}
