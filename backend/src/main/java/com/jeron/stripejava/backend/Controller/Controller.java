package com.jeron.stripejava.backend.Controller;

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
    
    


    

    @PostMapping("/checkout/session")
    public StartCheckoutSession newCheckoutSession(@RequestBody CheckoutRequestDTO requestBody) throws StripeException {
        StartCheckoutSession checkoutSession = new StartCheckoutSession(requestBody);
        return checkoutSession;

    }

}
