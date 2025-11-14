package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String size;
    private String bunType;
    private List<Toppings> toppings;
    private boolean special;
    private String specialType;

    public Item(String size, String bunType) {
        this.size = size;
        this.bunType = bunType;
        this.toppings = new ArrayList<>();
        this.special = false;
        this.specialType = "";
    }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public void setSpecial(String type) {
        this.special = true;
        this.specialType = type;
    }

    public double getPrice() {
        double price = getBasePrice();

        for (Toppings topping : toppings) {
            price += topping.getPrice(size);
        }

        if (special) {
            price += getSpecialCost();
        }

        return price;
    }

    private double getBasePrice() {
        switch (size) {
            case "Small":
                return 3.50;
            case "Med":
                return 9.00;
            case "Large":
                return 8.50;
            default:
                return 0.0;
        }
    }

    private double getSpecialCost() {
        switch (size) {
            case "Small":
                return 0.50;
            case "Med":
                return 1.00;
            case "Large":
                return 1.50;
            default:
                return 0.0;
        }
    }

    public String getName() {
        String name = size + " " + bunType + " Hot Dog";

        if (special) {
            name += " (" + specialType + ")";
        }

        return name;
    }

    @Override
    public String toString() {
        String result = getName() + " - $" + String.format("%.2f", getBasePrice());


        if (!toppings.isEmpty()) {
            result += "\n  Toppings:";
            for (Toppings topping : toppings) {
                result += "\n  " + topping.getName();
                if(!toppings.isEmpty()) {
                }
                // Clean Up and make it Prices are displayed make sure it is catching the prices
                if (topping.isExtra()) {
                    result += " (Extra)";
                }
                double toppingPrice = topping.getPrice(size);
                if (toppingPrice > 0) {
                    result += ": $" + String.format("%.2f", toppingPrice);
                }
            }
        }

        if (special) {
            result += "\n  Special (" + specialType + "): $";
            result += String.format("%.2f", getSpecialCost());
        }

        result += "\n  TOTAL: $" + String.format("%.2f", getPrice());

        return result;
    }
}