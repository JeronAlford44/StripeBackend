package com.jeron.stripejava.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		String STRIPE_API_KEY = "sk_test_51P9sC2KLCmwYX1xyGmesr1XPN1NsNHi9w8W3ViwTYP5IduPpB4ndtmyEgEApY1B36kW3LzKNV3S8xfFNWrHNZHYG00UzyQVOMw";
		Stripe.apiKey = STRIPE_API_KEY;
		
		SpringApplication.run(BackendApplication.class, args);
	}

}
