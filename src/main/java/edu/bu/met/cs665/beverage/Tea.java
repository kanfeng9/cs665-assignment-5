package edu.bu.met.cs665.beverage;

public abstract class Tea extends Beverage {

    public Tea(String n, int s) {
        super(n, s);
    }

    // Getter method for brew time
    public abstract int getBrewTime();
}
