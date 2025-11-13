package com.plurasight;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> items;
    private List<Drinks> drinks;
    private List<Side> sides;

    public Order() {
        items = new ArrayList<>();
        drinks = new ArrayList<>();
        sides = new ArrayList<>();
    }

    ///  Add items
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Hot Dog Added");
    }

    public void addDrink(Drinks drink) {
        drinks.add(drink);
        System.out.println("Drink Added");
    }

    public void addSide(Side side) {
        sides.add(side);
        System.out.println("Side Added");
    }

    ///  Display
    public void displayOrder() {
        System.out.println("---------------------");

        if (items.isEmpty() && drinks.isEmpty() && sides.isEmpty()) {
            System.out.println("No items added");
            System.out.println("No drinks added");
            System.out.println("No sides added");
            System.out.println("---------------------");
            return;
        }

        // Items
        if (items.isEmpty()) {
            System.out.println("No Hot Dog added");
        } else {
            System.out.println("\nHot Dog displayed");
            for (int i = items.size() - 1; i >= 0; i--) {
                Item item = items.get(i);
                System.out.println(item.toString());
            }
        }

        // Drinks
        if (drinks.isEmpty()) {
            System.out.println("No Drink added");
        } else {
            System.out.println("\nDrinks Displayed");
            for (int i = drinks.size() - 1; i >= 0; i--) {
                Drinks drink = drinks.get(i);
                System.out.printf("  - %s: $%.2f%n", drink.getName(), drink.getPrice());
            }
        }

        // Sides
        if (sides.isEmpty()) {
            System.out.println("No sides added");
        } else {
            System.out.println("\nSide Added");
            for (int i = sides.size() - 1; i >= 0; i--) {
                Side side = sides.get(i);
                System.out.printf("  - %s: $%.2f%n", side.getName(), side.getPrice());
            }
        }

        // Total
        System.out.println("\n---------------------");
        System.out.printf("Total Price: $%.2f%n", getTotalPrice());
        System.out.println("---------------------");
    }


    public boolean isEmpty() {
        return items.isEmpty() && drinks.isEmpty() && sides.isEmpty();
    }

    public boolean isValid() {
        if (items.isEmpty()) {
            return drinks.isEmpty() && sides.isEmpty();
        }
        return true;
    }

    /// Price
    public double getTotalPrice() {
        double totalPrice = 0;

        for (Item item : items) {
            totalPrice += item.getPrice();
        }

        for (Drinks drink : drinks) {     // FIXED
            totalPrice += drink.getPrice();
        }

        for (Side side : sides) {
            totalPrice += side.getPrice();
        }

        return totalPrice;
    }
}