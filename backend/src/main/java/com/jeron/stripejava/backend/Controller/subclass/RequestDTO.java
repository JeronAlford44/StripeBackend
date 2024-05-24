package com.jeron.stripejava.backend.Controller.subclass;

import com.stripe.model.Product;

public class RequestDTO {
    Product[] items;
    String customerName;
    String customerEmail;

    public Product getFirstItem(){
        
        if (items.length > 0){
            return items[0];
        }
        // empty product array
        return new Product();

        
    }
    public int getTotal(){
        int total = 0;
        if (items.length  == 0){
            return 0;
        }

        for (int i = 0; i < items.length; i++){
            total = total + Integer.parseInt(items[i].getDefaultPrice());
        }
        return total;
    }
    public Product[] getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

}