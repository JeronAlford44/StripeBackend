package com.jeron.stripejava.backend.Auth;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import java.util.UUID;

public class Authentication {
    public static void main(String[] args) throws StripeException {
        // Retrieve Stripe API key from environment variables

        // Set the API key for Stripe
        Stripe.apiKey = "sk_test_51P9sC2KLCmwYX1xyGmesr1XPN1NsNHi9w8W3ViwTYP5IduPpB4ndtmyEgEApY1B36kW3LzKNV3S8xfFNWrHNZHYG00UzyQVOMw";

    }
}
