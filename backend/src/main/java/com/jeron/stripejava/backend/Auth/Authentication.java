package com.jeron.stripejava.backend.Auth;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import java.util.UUID;
public class Authentication {
    public static void main(String[] args) throws StripeException {
        // Retrieve Stripe API key from environment variables
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String stripeApiKey = System.getenv("STRIPE_API_KEY");

        // Set the API key for Stripe
        Stripe.apiKey = stripeApiKey;

        // Set up request options with the API key
        RequestOptions requestOptions = RequestOptions.builder()
                .setApiKey(stripeApiKey)
                .build();

        // Example: Retrieve a charge using the RequestOptions
        Charge charge = Charge.retrieve("ch_3Ln3ga2eZvKYlo2C11iwHdxy", requestOptions);
        System.out.println(charge);
    }
}
