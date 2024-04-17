package edu.bu.met.cs665.beverage.tea_subclasses;

import edu.bu.met.cs665.beverage.Tea;

// Represents a Black Tea, extending the general Tea class
public class Black extends Tea {

    // Constructor for Black Tea class, taking name and size as parameters
    public Black(String name, int size) {
        super(name, size); // Call the superclass (Tea) constructor
    }

    // Getter method for brew time
    @Override
    public int getBrewTime() {
        // Define the brew time for Black Tea in seconds
        return 120;
    }
}
