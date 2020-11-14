package com.example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ConsumerApplication {
	public final Logger logger = LoggerFactory.getLogger(getClass());

	@KafkaListener(topics = "payment", groupId = "bank-branch")
	public void consume(String message) {
		logger.info("Received: {}", message);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
