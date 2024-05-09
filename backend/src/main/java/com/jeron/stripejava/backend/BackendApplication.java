package com.jeron.stripejava.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		System.out.println(("Stripe Key: " + System.getenv("STRIPE_API_KEY")));
		SpringApplication.run(BackendApplication.class, args);
	}

}
