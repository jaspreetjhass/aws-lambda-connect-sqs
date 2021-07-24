package com.springbank.lambdas;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.sqs.AmazonSQS;
import com.springbank.aws.basics.configurations.AWSProperties;
import com.springbank.aws.basics.configurations.AWSProperties.Services;
import com.springbank.aws.basics.configurations.AWSProperties.Services.SQS;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SQSPublisher implements Function<SQSEvent, String> {

	@Autowired
	private AmazonSQS amazonSqs;
	@Autowired
	private AWSProperties awsProperties;

	@Override
	public String apply(final SQSEvent sqsEvent) {
		final Services services = awsProperties.getServices();
		final SQS sqs = services.getSqs();
		final String queueUrl = sqs.getQueueUrl();
		sqsEvent.getRecords().forEach(sqsMessage -> {
			log.info("message payload is : {}.", sqsMessage.getBody());
			amazonSqs.sendMessage(queueUrl, sqsMessage.getBody());
			log.info("message: {} is published to queue : {}.", sqsMessage.getBody(), queueUrl);
		});
		return "message is published successfully";
	}

}
