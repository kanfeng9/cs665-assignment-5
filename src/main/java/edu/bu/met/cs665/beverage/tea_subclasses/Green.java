package edu.bu.met.cs665.beverage.tea_subclasses;

import edu.bu.met.cs665.beverage.Tea;

// Represents a Green Tea, extending the general Tea class
public class Green extends Tea {

    // Constructor for Green Tea class, taking name and size as parameters
    public Green(String name, int size) {
        super(name, size); // Call the superclass (Tea) constructor
    }

    // Getter method for brew time
    @Override
    public int getBrewTime() {
        // Define the brew time for Green Tea in seconds
        return 120;
    }
}
