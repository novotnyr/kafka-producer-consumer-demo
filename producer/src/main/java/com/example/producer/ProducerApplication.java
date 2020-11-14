package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication {
	int messageId;

	@Autowired
	KafkaTemplate<String, String> kafka;

	@Scheduled(fixedDelay = 2000)
	public void publish() {
		kafka.send("payment", "Paid some money " + Instant.now() + " " + messageId);
		messageId++;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}
