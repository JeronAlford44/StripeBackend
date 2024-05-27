package com.jeron.stripejava.backend.Stripe.subclass;

import java.util.List;

public class CheckoutRequestDTO {
    public List<LineItem> lineItems;

    public static class LineItem {
        public String cost;
        public long quantity;
        public String itemName;

        
    }
}
