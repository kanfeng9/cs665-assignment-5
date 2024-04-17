package edu.bu.met.cs665.beverage.coffee_subclasses;

import edu.bu.met.cs665.beverage.Coffee;

// Represents an Americano coffee, extending the general Coffee class
public class Americano extends Coffee {

    // Constructor for Americano class, taking name and size as parameters
    public Americano(String name, int size) {
        super(name, size); // Call the superclass (Coffee) constructor
    }

    // Getter method for brew time
    @Override
    public int getBrewTime() {
        // Define the brew time for an Americano in seconds
        return 30;
    }
}
