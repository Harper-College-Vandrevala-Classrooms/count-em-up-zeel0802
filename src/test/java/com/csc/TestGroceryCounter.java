package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

    GroceryCounter counter;

    @BeforeEach
    void setUp() {
        // Initialize counter before each test
        counter = new GroceryCounter();
    }

    @Test
    void testDefaultConstructor() {
        // Test that the default constructor initializes to $00.00
        assertEquals("$00.00", counter.total());
    }

    @Test
    void testCustomStartingValue() {
        // Test custom starting value of $50.00
        counter = new GroceryCounter(5000);
        assertEquals("$50.00", counter.total());  // Should return $50.00
        
        // Test invalid starting value (should default to $00.00)
        counter = new GroceryCounter(15000);  // Invalid, so should default to 0000
        assertEquals("$00.00", counter.total());
    }

    @Test
    void testIncrementMethods() {
        // Test incrementing different places
        counter.incrementTens();
        assertEquals("$10.00", counter.total());

        counter.incrementOnes();
        assertEquals("$11.00", counter.total());

        counter.incrementTenths();
        assertEquals("$11.10", counter.total());

        counter.incrementHundredths();
        assertEquals("$11.11", counter.total());
    }

    @Test
    void testOverflow() {
        // Test overflow behavior
        counter = new GroceryCounter(9999);  // Start at $99.99
        counter.incrementHundredths();  // This should cause overflow
        assertEquals("$00.00", counter.total());
        assertEquals(1, counter.getNumberOfOverflows());
    }
}
