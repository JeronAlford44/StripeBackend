package com.jeron.stripejava.backend.Stripe;

import com.jeron.stripejava.backend.Controller.subclass.PaymentRequestDTO;
import com.jeron.stripejava.backend.Stripe.subclass.CheckoutRequestDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.checkout.Session;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StartCheckoutSession {
    public String sessionUrl;
    
    private Price CreateNewItemPrice(String itemName, String cost) throws StripeException {
        // need to consider how to cache price Id's to avoid having to re-generate each price for each user.
        BigDecimal priceInDollars = new BigDecimal(cost);
        long priceInCents = priceInDollars.multiply(BigDecimal.valueOf(100)).longValue();

        PriceCreateParams params = PriceCreateParams.builder()
                .setCurrency("usd")
                .setUnitAmount(priceInCents)
                .setProductData(
                        PriceCreateParams.ProductData.builder().setName(itemName).build())
                .build();
        Price price = Price.create(params);
        return price;
        
    
   
    }
    public StartCheckoutSession(CheckoutRequestDTO checkoutRequestDTO) throws StripeException {

       
        String YOUR_DOMAIN = "http://localhost:4242";

        // Create a list to hold line item parameters
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

        // Iterate through the line items in the request and add them to the list
        for (CheckoutRequestDTO.LineItem item : checkoutRequestDTO.lineItems) {
                Price itemPrice = CreateNewItemPrice(item.itemName, item.cost);
            lineItems.add(
                    SessionCreateParams.LineItem.builder()
                            .setQuantity(item.quantity)
                            .setPrice(itemPrice.getId()) // Provide the exact Price ID
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
