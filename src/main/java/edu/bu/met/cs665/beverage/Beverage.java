package edu.bu.met.cs665.beverage;

import java.util.HashMap;
import java.util.Map;

public class Beverage {
    private String name;
    private int size;
    private final Map<String, Integer> condiments = new HashMap<>();

    public Beverage(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean addCondiment(String type, int amount) {
        if (!type.equals("Milk") && !type.equals("Sugar")) {
            throw new IllegalArgumentException("Invalid condiment type.");
        }
        if (amount < 0 || amount > 3) {
            throw new IllegalArgumentException("Amount per addition must be between 0 and 3.");
        }
        int currentAmount = condiments.getOrDefault(type, 0);
        if (currentAmount + amount > 3) {
            return false; // Cannot exceed 3 units of any single condiment
        }
        if (getTotalCondiments() + amount > 6) {
            return false; // Total condiments cannot exceed 6 units
        }
        condiments.put(type, currentAmount + amount);
        return true;
    }

    public int getTotalCondiments() {
        return condiments.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getCondimentQuantity(String type) {
        return condiments.getOrDefault(type, 0);
    }

    // Existing toString, hashCode, and equals methods...
}
