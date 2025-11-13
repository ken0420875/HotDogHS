package com.plurasight;

public class RegToppings extends Toppings {
    private String name;

    public RegToppings(String name) {
        super(name, false);
        this.name = name;
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

    public String getName() {
        return name;
    }
}
