package com.plurasight;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private List<Item> items;
    private List<Drink> drinks;
    private List<Side> sides;

    public Order() {
        items = new ArrayList<>();
        drinks = new ArrayList<>();
        sides = new ArrayList<>();
    }

    ///  Methods
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Hot Dog Added");
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
        System.out.println(" Drink Added");
    }

    public void addSide(Side side) {
        sides.add(side);
        System.out.println("Side Added");
    }

    /// IF it's empty
    /// Recommend Using &'s

    public void displayOrder(){
        System.out.println("---------------------");

        if(items.isEmpty() && drinks.isEmpty() && sides.isEmpty()) {
            System.out.println("No items added");
            System.out.println("No drinks added");
            System.out.println("No sides added");
            System.out.println("---------------------");
            return;
        }

///  Items
        if(items.isEmpty()){
            System.out.println("No Hot Dog added");
        }else{
            System.out.println("\nHot Dog displayed");
            for(int i = items.size()-1; i>=0; i--) {
                Item item = items.get(i);
                System.out.println(item.toString());
            }
        }

///  Drinks
        if(drinks.isEmpty()) {
            System.out.println("No Drink added");
        }else{
            System.out.println("\nDrinks Displayed");
            for (int i = drinks.size() - 1; i >= 0; i--) {
                Drink drink = drinks.get(i);
                System.out.printf("  - %s: $%.2f%n", drink.getName(), drink.getPrice());
            }
        }

///  Sides
        if(sides.isEmpty()) {
            System.out.println("No sides added");
        }else{
            System.out.println("\nSide Added");
            for(int i = sides.size()-1; i>=0; i--) {
                Side side = sides.get(i);
                System.out.printf("  - %s: $%.2f%n", side.getName(), side.getPrice());
            }
        }

///  Total for prices
        System.out.println("\n---------------------");
        System.out.printf("Total Price: $%.2f%n", getTotalPrice());
        System.out.println("---------------------");
    }
    public boolean isEmpty(){
        return items.isEmpty() && drinks.isEmpty() && sides.isEmpty();
    }
    public boolean isValid(){
        if(items.isEmpty()){
            return drinks.isEmpty() && sides.isEmpty();
        }
        return true;
    }




    ///  Item

    ///  Drink
    public class Drink {
        private String name;
        private double price;

        public Drink(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
        /// Side
    }

    public class Side {
        private String name;
        private double price;

        public Side(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
    /// Getting Item and Calculations
    public double getTotalPrice() {
        double totalPrice = 0;
        for(Item item : items){
            totalPrice += item.getPrice();
        }
        /// Drinks
        for(Drink drink : drinks){
            totalPrice += drink.getPrice();
        }
        /// Sides
        for(Side side : sides){
            totalPrice += side.getPrice();
        }
        return totalPrice;
    }
}

