package com.plurasight;
/// Make child class
public abstract class Toppings {
    protected String name;
    protected boolean extra;
    public Toppings(String name, boolean extra) {
        this.name = name;
        this.extra = extra;
    }

    public Toppings(String name, String extra) {
    }

    public abstract double getPrice(String size);

    public String getName() {
        return name;
    }
    public boolean isExtra() {
        return extra;
    }
    @Override
    public String toString() {
        return name + (extra ? "Extra" : "");
    }
}
