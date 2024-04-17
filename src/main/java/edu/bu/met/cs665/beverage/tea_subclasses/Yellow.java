package edu.bu.met.cs665.beverage.tea_subclasses;

import edu.bu.met.cs665.beverage.Tea;

// Represents a Yellow Tea, extending the general Tea class
public class Yellow extends Tea {

    // Constructor for Yellow Tea class, taking name and size as parameters
    public Yellow(String name, int size) {
        super(name, size); // Call the superclass (Tea) constructor
    }

    // Getter method for brew time
    @Override
    public int getBrewTime() {
        // Define the brew time for Yellow Tea in seconds
        return 120;
    }
}
