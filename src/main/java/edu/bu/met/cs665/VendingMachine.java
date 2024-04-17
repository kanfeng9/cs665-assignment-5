package edu.bu.met.cs665;

import edu.bu.met.cs665.beverage.Beverage;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private static final Logger logger = Logger.getLogger(VendingMachine.class);
    private final Map<Beverage, Integer> map = new HashMap<>();

    public VendingMachine(List<Beverage> beverages) {
        for (Beverage beverage : beverages) {
            addBeverage(beverage);
        }
        logger.info("Vending machine initialized.");
    }

    private void addBeverage(Beverage b) {
        map.put(b, map.getOrDefault(b, 0) + 1);
        logger.info(String.format("%s added to vending machine. Current quantity: %d", b.getName(), map.get(b)));
    }

    public Beverage getBeverage(Beverage b) {
        if (!map.containsKey(b)) {
            logger.error("Attempted to retrieve a non-existent beverage");
            return null;
        }
        if (map.get(b) == 0) {
            logger.warn(String.format("Zero %s remaining. Removing from vending machine", b.getName()));
            map.remove(b);
            return null;
        }
        map.put(b, map.get(b) - 1);
        logger.info(String.format("Dispensed one %s. Remaining: %d", b.getName(), map.get(b)));
        return b;
    }

    public void displayMachine() {
        if (map.isEmpty()) {
            logger.info("Nothing to display.");
            return;
        }
        for (Map.Entry<Beverage, Integer> entry : map.entrySet()) {
            System.out.printf("Beverage: %s | Quantity: %s\n", entry.getKey().getName(), entry.getValue());
        }
    }
}
