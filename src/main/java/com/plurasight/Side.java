package com.plurasight;

public class Side {
    private String type;

    public Side(String type) {
        this.type = type;
    }

    public double getPrice(){
        return 1.50;
    }
    public String getName() {
        return type;
    }
    @Override
    public String toString() {
        return getName() + "- $" + String.format("%.2f",getPrice());
    }
}
