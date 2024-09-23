package com.csc;

public class GroceryCounter {

    private int counter;
    private int numberOfOverflows;
    private int maxCounter; // Custom max counter value

    // Default max value for the counter
    private static final int DEFAULT_MAX_COUNTER = 9999;

    // Constructor for custom starting value and custom max counter
    public GroceryCounter(int startingValue, int maxCounter) {
        if (startingValue >= 0 && startingValue <= maxCounter) {
            this.counter = startingValue;
        } else {
            this.counter = 0;
        }
        if (maxCounter > 0) {
            this.maxCounter = maxCounter;
        } else {
            this.maxCounter = DEFAULT_MAX_COUNTER;
        }
        this.numberOfOverflows = 0;
    }

    // Default constructor with default max value (9999)
    public GroceryCounter() {
        this(0, DEFAULT_MAX_COUNTER);
    }

    // Increment the ones place
    public void incrementOnes() {
        counter++;
        if (counter > maxCounter) {
            counter = 0; // Reset to zero on overflow
            numberOfOverflows++;
        }
    }

    // Return the total as a formatted string
    public String total() {
        int dollars = counter / 100;
        int cents = counter % 100;
        return String.format("$%02d.%02d", dollars, cents);
    }

    // Return the number of overflows
    public int getNumberOfOverflows() {
        return numberOfOverflows;
    }

    // Clear the counter and reset the overflow count
    public void clear() {
        this.counter = 0;
        this.numberOfOverflows = 0;
    }
}
