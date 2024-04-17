package edu.bu.met.cs665.beverage.coffee_subclasses;

import edu.bu.met.cs665.beverage.Coffee;

// Represents a Latte coffee, extending the general Coffee class
public class Latte extends Coffee {

    // Constructor for Latte class, taking name and size as parameters
    public Latte(String name, int size) {
        super(name, size); // Call the superclass (Coffee) constructor
    }

    // Getter method for brew time
    @Override
    public int getBrewTime() {
        // Define the brew time for a Latte in seconds
        return 30;
    }
}
