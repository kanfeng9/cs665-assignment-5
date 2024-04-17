package edu.bu.met.cs665;

import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.beverage.BeverageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        Scanner scanner = new Scanner(System.in);
        List<Beverage> beverageList = new ArrayList<>();

        System.out.println("Welcome to the Automated Beverage Vending Machine.");
        boolean addingBeverages = true;

        while (addingBeverages) {
            try {
                System.out.println("Enter the type of beverage to add ('Espresso', 'Americano', 'Latte', 'Green Tea', 'Black Tea', 'Yellow Tea'): ");
                String beverageType = scanner.nextLine();

                System.out.println("Enter the size (1 for small, 2 for medium, 3 for large): ");
                int size = Integer.parseInt(scanner.nextLine());
                if (size < 1 || size > 3) {
                    System.out.println("Invalid size. Please enter 1, 2, or 3.");
                    continue;
                }

                Beverage beverage = BeverageFactory.createBeverage(beverageType, size);
                beverageList.add(beverage);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to add another beverage? (yes/no): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                addingBeverages = false;
            }
        }

        VendingMachine machine = new VendingMachine(beverageList);
        logger.info("Vending Machine initialized with beverages.");
        machine.displayMachine();

        scanner.close();
    }
}
