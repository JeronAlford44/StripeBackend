package com.jeron.stripejava.backend.Controller.subclass;

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

public class PaymentIntentHandler {
    public String clientSecret;
    public PaymentIntentHandler(RequestDTO requestBody) throws StripeException{
        this.clientSecret = InitializePaymentIntent(requestBody);

    }
    
    private String InitializePaymentIntent(RequestDTO requestBody) throws StripeException {

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(Long.valueOf(requestBody.getTotal()))
                .setCurrency("usd")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build())
                .build(); 
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        final String clientSecret = paymentIntent.getClientSecret();
        return clientSecret;
    }
    
        
    
}
