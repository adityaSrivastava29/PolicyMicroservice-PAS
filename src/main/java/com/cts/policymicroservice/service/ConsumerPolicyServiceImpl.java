package com.cts.policymicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.policymicroservice.Clients.FeignServiceUtil;
import com.cts.policymicroservice.Clients.QuotesClient;
import com.cts.policymicroservice.dao.ConsumerPolicyRepository;
import com.cts.policymicroservice.entities.ConsumerPolicy;

@Service
public class ConsumerPolicyServiceImpl implements ConsumerPolicyService {

	@Autowired
	ConsumerPolicyRepository consumerPolicyRepository;

	@Autowired
	FeignServiceUtil feignServiceUtil;

	@Autowired
	QuotesClient quotesClient;

	public String saveToRepo(ConsumerPolicy consumerPolicy) {

		if (consumerPolicyRepository.existsById(consumerPolicy.getConsumerid())) {
			return " Policy already exists with id " + consumerPolicy.getConsumerid();
		}

		String quotes = quotesClient.getQuotes(consumerPolicy.getConsumerid(), consumerPolicy.getPropertyid());

		consumerPolicy.setAssuredSum(quotes);

		consumerPolicy.setPolicyStatus("Intialised");

		consumerPolicyRepository.save(consumerPolicy);

		return "Policy Created Successfully with consumer id " + consumerPolicy.getConsumerid() + " ,quote = Rs." + quotes
				+ " and policy ID = " + consumerPolicy.getPolicyId();
	}

	public List<ConsumerPolicy> findAll() {
		return consumerPolicyRepository.findAll();

	}

	public String updateConsumerPolicy(int id, ConsumerPolicy consumer) {
		Optional<ConsumerPolicy> optConsumer = consumerPolicyRepository.findById(id);
		if (!optConsumer.isPresent()) {

			throw new RuntimeException("Consumer with the id " + id + " does not exist");
		}
		ConsumerPolicy con = optConsumer.get();

		if (consumer.getPaymentStatus() != null) {
			con.setPaymentStatus(consumer.getPaymentStatus());
		}
		if (consumer.getAcceptanceStatus() != null) {
			con.setAcceptanceStatus(consumer.getAcceptanceStatus());
		}

		con.setPolicyStatus("Issued");

		consumerPolicyRepository.save(con);

		return "Consumer Policy updated succesfully";

	}

// | Output: Issue Status, Status Description)(FETCH USING ids + add paymetdetails & acceptancestatus)

	public String issuePolicy(ConsumerPolicy consumerPolicy) {

		if (!consumerPolicyRepository.existsById(consumerPolicy.getPolicyId())) {
			return "Policy ID does not exist!";
		}
		if (consumerPolicyRepository.findByConsumerid(consumerPolicy.getConsumerid()).isEmpty()) {
			return "Consumer ID does not exist!";
		}


		updateConsumerPolicy(consumerPolicy.getPolicyId(), consumerPolicy);

		return "Payment Status of Policy is = " + consumerPolicy.getPaymentStatus();

	}

	public ConsumerPolicy getPolicy(int id) {
		Optional<ConsumerPolicy> found = consumerPolicyRepository.findById(id);
		if(found.isPresent()) {
			 ConsumerPolicy policy = found.get();
			 return policy;
		}
		return null;
	}

}
