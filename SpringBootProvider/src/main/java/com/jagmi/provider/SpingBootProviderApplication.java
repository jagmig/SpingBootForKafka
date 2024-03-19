package com.jagmi.provider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpingBootProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootProviderApplication.class, args);
	}
	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			kafkaTemplate.send("Jorge-Topic", "Prueba final de Spring Boot con Kafka sale");
		};
	}

}