package edu.bu.met.cs665;

import edu.bu.met.cs665.beverage.Beverage;
import edu.bu.met.cs665.beverage.coffee_subclasses.Espresso;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTests {

    private VendingMachine machine;
    private Beverage espresso;

    @Before
    public void setUp() {
        List<Beverage> beverages = new ArrayList<>();
        espresso = new Espresso("Espresso", 1); // Assume Espresso has a name, size, and can handle condiments
        beverages.add(espresso);
        machine = new VendingMachine(beverages);
    }

    @Test
    public void testRetrieveBeverage() {
        Beverage retrieved = machine.getBeverage(espresso);
        assertNotNull("Beverage should be retrieved", retrieved);
        assertEquals("Retrieved beverage should be Espresso", "Espresso", retrieved.getName());

        retrieved = machine.getBeverage(espresso);
        assertNull("Beverage should not be retrieved as it's out of stock", retrieved);
    }

    // Test adding valid amounts of condiments
    @Test
    public void testAddingValidCondiments() {
        espresso.addCondiment("Milk", 2);
        espresso.addCondiment("Sugar", 2);
        assertEquals("Total condiments should be 4", 4, espresso.getTotalCondiments());
    }

    // Test exceeding individual condiment limit
    @Test(expected = IllegalArgumentException.class)
    public void testExceedingCondimentLimits() {
        Beverage espresso = new Espresso("Espresso", 1);
        espresso.addCondiment("Milk", 4); // This should throw IllegalArgumentException since the limit is 3
    }


    // Test exceeding total condiment limit
    @Test
    public void testExceedingCombinedCondimentLimit() {
        assertTrue(espresso.addCondiment("Milk", 3)); // 3 units of milk
        assertTrue(espresso.addCondiment("Sugar", 2)); // 2 units of sugar, total 5
        assertFalse("Should not allow adding more units to exceed total of 6", espresso.addCondiment("Sugar", 2)); // Attempt to exceed total limit
    }


    // Test adding condiments in multiple steps
    @Test
    public void testAddingCondimentsInSteps() {
        assertTrue("Adding 1 unit of milk should succeed", espresso.addCondiment("Milk", 1));
        assertTrue("Adding another 2 units of milk should succeed", espresso.addCondiment("Milk", 2));
        assertEquals("Total milk added should be 3", 3, espresso.getCondimentQuantity("Milk"));
    }

    // Additional tests can be implemented as needed
}
