package com.jeron.stripejava.backend.Stripe;

import com.jeron.stripejava.backend.Controller.subclass.RequestDTO;
import com.jeron.stripejava.backend.Stripe.subclass.CheckoutRequestDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import java.util.ArrayList;
import java.util.List;

public class StartCheckoutSession {
    public String sessionUrl;

    public StartCheckoutSession(CheckoutRequestDTO checkoutRequestDTO) throws StripeException {
        String YOUR_DOMAIN = "http://localhost:4242";

        // Create a list to hold line item parameters
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

        // Iterate through the line items in the request and add them to the list
        for (CheckoutRequestDTO.LineItem item : checkoutRequestDTO.lineItems) {
            lineItems.add(
                    SessionCreateParams.LineItem.builder()
                            .setQuantity(item.quantity)
                            .setPrice(item.priceId) // Provide the exact Price ID
                            .build());
        }

        // Build the session parameters with all line items
        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(YOUR_DOMAIN + "?success=true")
                .setCancelUrl(YOUR_DOMAIN + "?canceled=true")
                .addAllLineItem(lineItems)
                .build();

        // Create the session
        Session session = Session.create(params);
        this.sessionUrl = session.getUrl();
    }
}
