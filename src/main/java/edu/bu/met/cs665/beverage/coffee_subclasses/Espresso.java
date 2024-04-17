package edu.bu.met.cs665.beverage.coffee_subclasses;

import edu.bu.met.cs665.beverage.Coffee;

// Represents an Espresso coffee, extending the general Coffee class
public class Espresso extends Coffee {

    // Constructor for Espresso class, taking name and size as parameters
    public Espresso(String name, int size) {
        super(name, size); // Call the superclass (Coffee) constructor
    }

    // Getter method for brew time
    @Override
    public int getBrewTime() {
        // Define the brew time for an Espresso in seconds
        return 30;
    }
}
