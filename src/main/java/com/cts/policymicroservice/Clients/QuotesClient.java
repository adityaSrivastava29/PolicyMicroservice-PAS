package com.cts.policymicroservice.Clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="feignQuote", url="http://localhost:9004" )

public interface QuotesClient {

	
	@GetMapping("/HealthCheckQuote")
	public String getHealthQuote();
		
		@GetMapping("/getQuotesForPolicy/{id}/{pid}")
		public String getQuotes( @PathVariable int id,@PathVariable int pid);

		
		
	}
