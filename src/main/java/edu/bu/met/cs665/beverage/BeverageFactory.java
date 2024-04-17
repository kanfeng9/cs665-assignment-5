package edu.bu.met.cs665.beverage;

import edu.bu.met.cs665.beverage.coffee_subclasses.*;
import edu.bu.met.cs665.beverage.tea_subclasses.*;

public class BeverageFactory {
    public static Beverage createBeverage(String type, int size) {
        switch (type.toLowerCase()) {
            case "espresso":
                return new Espresso(type, size);
            case "americano":
                return new Americano(type, size);
            case "latte":
                return new Latte(type, size);
            case "green tea":
                return new Green(type, size);
            case "black tea":
                return new Black(type, size);
            case "yellow tea":
                return new Yellow(type, size);
            default:
                throw new IllegalArgumentException("Invalid beverage type.");
        }
    }
}
