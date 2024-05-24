package com.jeron.stripejava.backend.Controller;

import com.jeron.stripejava.backend.Controller.subclass.PaymentIntentHandler;
import com.jeron.stripejava.backend.Controller.subclass.RequestDTO;
import com.jeron.stripejava.backend.Stripe.StartCheckoutSession;
import com.jeron.stripejava.backend.Stripe.subclass.CheckoutRequestDTO;
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
public class Controller {

    String STRIPE_API_KEY = "sk_test_51P9sC2KLCmwYX1xyGmesr1XPN1NsNHi9w8W3ViwTYP5IduPpB4ndtmyEgEApY1B36kW3LzKNV3S8xfFNWrHNZHYG00UzyQVOMw";

    @PostMapping("/checkout/hosted")
    // Body of POST Request will be of type RequestDTO -> {Product[] items; String
    // customerName;String customerEmail;}
    public String hostedCheckout(@RequestBody RequestDTO requestBody) throws StripeException {
        System.out.println(STRIPE_API_KEY);
        System.out.println(requestBody.getItems());
        return "";
    }

    RequestDTO test = new RequestDTO();

    @PostMapping("/checkout/payment_intent")
    public String newPaymentIntent(@RequestBody RequestDTO requestBody) throws StripeException {
        System.out.println(requestBody);
        final PaymentIntentHandler paymentIntentHandler = new PaymentIntentHandler(requestBody);
        final String clientSecret = paymentIntentHandler.clientSecret;
        return clientSecret;

    }

    @PostMapping("/checkout/session")
    public String newCheckoutSession(@RequestBody CheckoutRequestDTO requestBody) throws StripeException {
        StartCheckoutSession checkoutSession = new StartCheckoutSession(requestBody);
        return checkoutSession.sessionUrl;

    }

}
