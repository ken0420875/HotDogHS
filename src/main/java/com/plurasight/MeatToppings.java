package com.plurasight;

public class MeatToppings extends Toppings {
    public MeatToppings(String name, boolean extra){
        super(name, extra);
    }

    @Override
    public double getPrice(String size) {
        double price = 0;
        double extraPrice = 0;

        /// Meat Pricing
        switch (size) {
            case "Small":
                price = 1.0;
                extraPrice = 0.50;
                break;
                case "Med":
                    price = 2.00;
                extraPrice = 1.00;
                break;
                case "Large":
                    price = 3.00;
                    extraPrice = 1.50;
                    break;
        }
        return extra ? price + extraPrice : price;
    }
}
