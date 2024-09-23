package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

    GroceryCounter counter;

    @BeforeEach
    void setUp() {
        counter = new GroceryCounter();
    }

    // Test for custom max counter (e.g., max = 5000)
    @Test
    void testCustomCounterMaximum() {
        // Create a counter with a custom maximum value of 5000
        counter = new GroceryCounter(0, 5000);

        // Increment until it reaches maxCounter (5000)
        for (int i = 0; i < 5000; i++) {
            counter.incrementOnes();
        }

        // Assert that the counter is at the maximum value
        assertEquals("$50.00", counter.total());

        // Increment one more time to cause overflow
        counter.incrementOnes();

        // Assert counter has reset after reaching maxCounter (5000)
        assertEquals("$00.00", counter.total()); // Should reset to zero after overflow

        // Assert overflow occurred
        assertEquals(1, counter.getNumberOfOverflows());
    }

    // Test invalid custom max counter (e.g., -100)
    @Test
    void testInvalidMaxCounter() {
        // Create a counter with an invalid max value (e.g., -100)
        counter = new GroceryCounter(0, -100);

        // Assert the counter has been reset
        assertEquals("$00.00", counter.total());
    }

    // Test clearing the counter
    @Test
    void testClear() {
        counter = new GroceryCounter(4000, 5000);
        counter.incrementOnes();
        counter.clear();
        assertEquals("$00.00", counter.total());
        assertEquals(0, counter.getNumberOfOverflows());
    }
}
