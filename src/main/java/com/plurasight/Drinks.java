package com.plurasight;

public class Drinks {
    public Drinks() {
    }
    private String size;
    private String flavor;

    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        switch (size) {
            case "Small":
                return 2.00;
                case "Medium":
                    return 2.50;
                    case "Large":
                        return 2.75;
                        default:
                            return 0.00;
        }
    }

    public String getName() {
        return size + " " + flavor;
    }
    @Override
    public String toString() {
        return getName() + " - $ " + String.format("%.2f", getPrice());
    }
}
