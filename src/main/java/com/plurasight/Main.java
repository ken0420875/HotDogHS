package com.plurasight;

import java.util.Scanner;


class MainClass {

    ///  Home Screen
    public static void main(String[] args) throws IllegalStateException {
        Scanner scanner;
        scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("==============================");
        System.out.println("     Ken's Full Franks   ");
        System.out.println("==============================");

        while (running) {
            System.out.println("      HOME SCREEN             ");
            System.out.println("  O) Order Here");
            System.out.println("  E) Exit ");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            ///  Customer chooses option
            switch (choice) {
                case "O":
                    beginNewOrder(scanner);
                    /// Order begins

                    break;
                case "E":

                    System.out.println("Good Bye");
                    running = false;
                    break;

                default:
                    System.out.println("Try Again");
            }
        }
        scanner.close();
    }


    ///  Customer Begins Order
    private static void beginNewOrder(Scanner scanner) {
        Order order = new Order();
        boolean running = true;
        System.out.println("============= CURRENT ORDER ================");

        while (running) {
            order.displayOrder();

            System.out.println("============= MENU ================");
            System.out.println("1. Add Hot Dog");
            System.out.println("2. Add Drink");
            System.out.println("3. Add side");
            System.out.println("4. Finish Order");
            System.out.println("5. Exit Order");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHotDog(scanner, order);
                    break;

                case "2":
                    addDrink(scanner, order);
                    break;

                case "3":
                    addSide(scanner, order);
                    break;

                case "4":
                    checkingout(scanner, order);
                    running = false;
                    break;

                case "5":
                    System.out.println("Good Bye");
                    running = false;

            }

        }
    }

    /// Customer adds Hot Dog
    ///
    /// @return
    private static void addHotDog(Scanner scanner, Order order) {
        System.out.println("============= HOT DOG ================");

        /// Size
        String size = "";
        boolean sizeFound = false;

        while (!sizeFound) {
            System.out.print("\nEnter the size of the hot dog: ");
            System.out.println("\n======== Size Options =======");
            System.out.println("S) Small - 3.95");
            System.out.println("M) Med - 6.50");
            System.out.println("L) Large - 9.50");
            System.out.println("Choose here: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "S":
                    size = "Small";
                    sizeFound = true;
                    break;
                case "M":
                    size = "Med";
                    sizeFound = true;
                    break;
                case "L":
                    size = "Large";
                    sizeFound = true;
                    break;
                default:
                    System.out.println("Try Again");
            }
        }
        ///  Bun
        String bun = "";
        boolean bunFound = false;
        while (!bunFound) {
            System.out.print("\nEnter the bun type: ");
            System.out.println("1) Regular");
            System.out.println("2) Buttered");
            System.out.println("3) Pretzel");
            System.out.println("4) Golden Brown");
            System.out.print("Choose here: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    bun = "Regular";
                    bunFound = true;
                    break;
                case "2":
                    bun = "Buttered";
                    bunFound = true;
                    break;
                case "3":
                    bun = "Pretzel";
                    bunFound = true;
                    break;
                case "4":
                    bun = "Golden Brown";
                    bunFound = true;
                    break;
                default:
                    System.out.println("Try Again");

            }
        }
        // Create hot dog

        Item hotdog = new Item(size, bun);

        // Add Cheese
        System.out.println("\n============= CHEESE TOPPINGS ================");
        System.out.println("Select the Cheese of your choice: ");
        System.out.println("1) American");
        System.out.println ("2) Sharp Cheddar");
        System.out.println("3) Pepper Jack");
        System.out.println("4) Swiss(Premium)");
        System.out.print("Choose here: ");
        System.out.print("!DISCLAIMER! If you don't want a specific cheese select 0 ");

        boolean addCheese = true;
        while (addCheese) {
            System.out.print("Choose cheese (0 to exit): ");
            String CheeseChoice = scanner.nextLine();
            if (CheeseChoice.equals("0")) {
                addCheese = false;
            } else {
                // Array Maybe?
                String cheese = "";
                boolean validCheeseChoice = false;
                // Switch Statements

                switch (CheeseChoice) {
                    case "1":
                        cheese = " American";
                        validCheeseChoice = true;
                        break;
                    case "2":
                        cheese = " Sharp Cheddar";
                        validCheeseChoice = true;
                        break;
                    case "3":
                        cheese = " Swiss";
                        validCheeseChoice = true;
                        break;
                    case "4":
                        cheese = " Monterey Jack";
                        validCheeseChoice = true;
                        break;
                    //  Add option for no cheese Later
                    default:
                        System.out.println("Try Again");
                }
                if (validCheeseChoice) {
                    System.out.print("Extra" + cheese + "? (Y/N) ");
                    String extraChoice = scanner.nextLine();
                    boolean validExtraChoice = extraChoice.equals("Y");

                    CheeseToppings meatTopping = new CheeseToppings(CheeseChoice, validExtraChoice);


                    System.out.println("Added " + CheeseChoice + (validExtraChoice ? " (Extra)" : "") + "!");
                }
            }
        }


        // Add Meat
        System.out.println("\n============= MEAT TOPPINGS ================");
        System.out.println("Select the meat of your choice: ");
        System.out.println("1) Pulled pork");
        System.out.println ("2) Bacon");
        System.out.println("3) Chili");
        System.out.println("4) Sausage");
        System.out.print("Choose here: ");
        System.out.print("!DISCLAIMER! If you don't want a meat select 0 ");

        boolean addMeat = true;
        while (addMeat) {
            System.out.print("Choose meat (0 to exit): ");
            String meatChoice = scanner.nextLine();
        if(meatChoice.equals("0")) {
            addMeat = false;
        } else {
            // Array Maybe?
            String meat = "";
            boolean validMeatChoice = false;
            // Switch Statements

            switch (meatChoice) {
                case "1":
                    meat = " Pulled Pork";
                    validMeatChoice = true;
                    break;
                    case "2":
                        meat = " Bacon";
                        validMeatChoice = true;
                        break;
                        case "3":
                            meat = " Chili";
                            validMeatChoice = true;
                            break;
                            case "4":
                                meat = " Sausage";
                                validMeatChoice = true;
                                break;
                                //  Add option for no meat Later
                default:
                            System.out.println("Try Again");
            }
            if(validMeatChoice) {
                System.out.print("Extra" + meat + "? (Y/N) ");
                String extraChoice = scanner.nextLine();
                boolean validExtraChoice = extraChoice.equals("Y");

                MeatToppings meatTopping = new MeatToppings(meatChoice, validExtraChoice);


                System.out.println("Added " + meat + (validExtraChoice ? " (Extra)" : "") + "!");
            }
        }
        }
        // Add Reg
        System.out.println("\n============= REGULAR (Free of charge) TOPPINGS ================");
        System.out.println("Select the topping of your choice: ");
        System.out.println("1) Sauerkraut");
        System.out.println ("2) Jalapenos");
        System.out.println("3) Relish");
        System.out.println("4) Chopped Tomatoes");
        System.out.print("5) Pickles ");
        System.out.print("Choose here: ");
        System.out.print("!DISCLAIMER! If you don't want a FREE regular topping select 0 ");

        boolean addRegular = true;
        while (addRegular) {
            System.out.print("Choose topping (0 to exit): ");
            String regChoice = scanner.nextLine();
            if (regChoice.equals("0")) {
                addRegular = false;
            } else {
                // Array Maybe?
                String ToppingChoice = "";
                boolean validToppingChoice = false;
                // Switch Statements

                switch (regChoice) {
                    case "1":
                        ToppingChoice = " Sauerkraut";
                        validToppingChoice = true;
                        break;
                    case "2":
                        ToppingChoice = " Jalapenos";
                        validToppingChoice = true;
                        break;
                    case "3":
                        ToppingChoice = " Relish";
                        validToppingChoice = true;
                        break;
                    case "4":
                        ToppingChoice = " Chopped Tomatoes";
                        validToppingChoice = true;
                        break;
                    case "5":
                        ToppingChoice = " Pickles";
                        validToppingChoice = true;
                        break;
                    //  Add option for no meat Later
                    default:
                        System.out.println("Try Again");
                }
                if (validToppingChoice) {
                    RegToppings regularTopping = new RegToppings(ToppingChoice);
                    hotdog.addTopping(regularTopping);
                    System.out.println("Added " + ToppingChoice + " (FREE)");

                }
            }
        }

        // Add Sauce

        System.out.println("\n============= SAUCES (Free of Charge) ================");
        System.out.println("Select sauces:");
        System.out.println("1) Ketchup");
        System.out.println("2) Mustard");
        System.out.println("3) Mayo");
        System.out.println("4) Hot Sauce");
        System.out.println("5) BBQ Sauce");
        System.out.println("0) Done with sauces");

        boolean addSauce = true;
        while (addSauce) {
            System.out.print("Choose sauce (0 to finish): ");
            String sauceChoice = scanner.nextLine().trim();

            if (sauceChoice.equals("0")) {
                addSauce = false;
            } else {
                String sauce = "";
                boolean validSauceChoice = false;

                switch (sauceChoice) {
                    case "1":
                        sauce = "Ketchup";
                        validSauceChoice = true;
                        break;
                    case "2":
                        sauce = "Mustard";
                        validSauceChoice = true;
                        break;
                    case "3":
                        sauce = "Mayo";
                        validSauceChoice = true;
                        break;
                    case "4":
                        sauce = "Hot Sauce";
                        validSauceChoice = true;
                        break;
                    case "5":
                        sauce = "BBQ Sauce";
                        validSauceChoice = true;
                        break;
                    default:
                        // make no sauce option
                        System.out.println("Invalid choice. Try again.");
                }

                if (validSauceChoice) {
                    RegToppings sauceTopping = new RegToppings(sauce);
                    hotdog.addTopping(sauceTopping);
                    System.out.println("Added " + sauce + " (FREE)");
                }
            }
        }

        // Add Special ( later )
// Add Special
        System.out.println("\n============= SPECIALIZATION ================");
        System.out.println("Would you like your hot dog specialized?");
        System.out.println("1) New York-Style");
        System.out.println("2) Chicago-Style");
        System.out.println("3) Seattle Dog");
        System.out.println("0) No specialization");
        System.out.print("Choose: ");

        String specialChoice = scanner.nextLine().trim();
        String specialType = "";

        switch (specialChoice) {
            case "1":
                specialType = "New York-Style";
                break;
            case "2":
                specialType = "Chicago-Style";
                break;
            case "3":
                specialType = "Seattle Dog";
                break;
            case "0":
                specialType = "";
                break;
            default:
                // Customize this
                System.out.println("Invalid choice. No specialization added.");
                specialType = "";
        }

        if (!specialType.equals("")) {
            hotdog.setSpecial(specialType);
            System.out.println("Added " + specialType + " specialization!");
        }


        // Last
        order.addItem(hotdog);
        System.out.println();


    }

// Replaced
    private static void addDrink(Scanner scanner, Order order) {
        System.out.println("\n============= ADD DRINK ================");
        String size = "";
        boolean validSize = false;

        while (!validSize) {
            System.out.print("Choose drink size (S/M/L: ");
            System.out.println("1) Small - 2.00");
            System.out.println("2) Med - 2.75");
            System.out.println("3) Large - 3.00");
            System.out.println("Choose here:");

       String drinkChoice = scanner.nextLine().trim();

       switch (size) {
           case "1":
               size = "Small";
               validSize = true;
               break;
               case "2":
                   size = "Med";
                   validSize = true;
                   break;
                   case "3":
                       size = "Large";
                       validSize = true;
                       break;
                       default:
                           System.out.println("Please choose a drink.");
       }
        }
///  Flavor
        System.out.print("Choose drink type: ");
        // Choose different drinks
        String flavor = scanner.nextLine().trim();

        Drink drink = new Drink()

    }



    private static void addSide(Scanner scanner, Order order) {
        System.out.println("Added Side");
    }
    private static void checkingout(Scanner scanner, Order order) {
        System.out.println("Checking out");
        if(order.isEmpty()) {
            System.out.println("Please choose either an item or a side and drink\n");
            return;
        }
        order.displayOrder();
        System.out.println("\nConfirm order?");
        String confirm = scanner.nextLine().trim().toUpperCase();
        if (confirm.equals("YES")) {
            System.out.println("Order has been checked out");
        } else  {
            System.out.println("Order has been checked out");

        }
    }
}
