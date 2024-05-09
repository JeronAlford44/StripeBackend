package com.jeron.stripejava.backend.Controller;


import com.jeron.stripejava.backend.RequestDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Product;

import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PaymentController {

    String STRIPE_API_KEY = System.getenv().get("STRIPE_API_KEY");
    

    @PostMapping("/checkout/hosted")
    // Body of POST Request will be of type RequestDTO -> {Product[] items; String customerName;String customerEmail;}
    String hostedCheckout(@RequestBody RequestDTO requestDTO) throws StripeException {
        System.out.println(STRIPE_API_KEY);
        System.out.println(requestDTO.getItems());
        return "Hello World!";
    }
    RequestDTO test = new RequestDTO();
    

}
