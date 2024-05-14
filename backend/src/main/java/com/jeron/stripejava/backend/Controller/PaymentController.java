package com.jeron.stripejava.backend.Controller;

import com.jeron.stripejava.backend.RequestDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Product;

import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
@RestController
@CrossOrigin
public class PaymentController {

    String STRIPE_API_KEY = System.getenv().get("STRIPE_API_KEY");
    

    @PostMapping("/checkout/hosted")
    // Body of POST Request will be of type RequestDTO -> {Product[] items; String customerName;String customerEmail;}
    public String hostedCheckout(@RequestBody RequestDTO requestDTO) throws StripeException {
        System.out.println(STRIPE_API_KEY);
        System.out.println(requestDTO.getItems());
        return "Hello World!";
    }
    RequestDTO test = new RequestDTO();
    @PostMapping("/checkout/payment_intent")
    public String newPaymentIntent(@RequestBody RequestDTO requestBody) throws StripeException{
        System.out.println(requestBody);

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(Long.valueOf(requestBody.getTotal()))
                .setCurrency("usd")
                // In the latest version of the API, specifying the `automatic_payment_methods`
                // parameter is optional because Stripe enables its functionality by default.
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build())
                .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        //fix process of obtaining client secret
        final String clientSecret = paymentIntent.getClientSecret();
        return clientSecret;

    }
   

}
