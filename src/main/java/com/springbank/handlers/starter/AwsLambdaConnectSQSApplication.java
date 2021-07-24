package com.springbank.handlers.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.springbank" })
public class AwsLambdaConnectSQSApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsLambdaConnectSQSApplication.class, args);
	}

}
