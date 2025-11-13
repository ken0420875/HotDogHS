package com.plurasight;

public class CheeseToppings extends Toppings {
    public CheeseToppings(String name, boolean extra){
        super(name, extra);
    }

    public double getPrice(String size) {
        double price = 0;
        double extraPrice = 0;

        /// Meat Pricing
        switch (size) {
            case "Small":
                price = 0.75;
                extraPrice = 0.30;
                break;
            case "Med":
                price = 1.50;
                extraPrice = 0.50;
                break;
            case "Large":
                price = 2.00;
                extraPrice = 0.70;
                break;

        }
        return extra ? price + extraPrice : price;
    }
}

