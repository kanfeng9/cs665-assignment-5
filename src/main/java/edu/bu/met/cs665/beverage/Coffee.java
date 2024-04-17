package edu.bu.met.cs665.beverage;

public abstract class Coffee extends Beverage {

    public Coffee(String n, int s) {
        super(n, s);
    }

    // Getter method for brew time
    public abstract int getBrewTime();
}
