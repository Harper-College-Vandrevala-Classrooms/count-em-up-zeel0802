package com.csc;

public class GroceryCounter {

    // Fields for the counter and overflow count
    private int counter;
    private int numberOfOverflows;
    private final int MAX_COUNTER = 9999;  // Default max value

    // Default constructor (initializes to 0000)
    public GroceryCounter() {
        this.counter = 0;
        this.numberOfOverflows = 0;
    }

    // Custom constructor for custom starting value
    public GroceryCounter(int startingValue) {
        if (startingValue >= 0 && startingValue <= MAX_COUNTER) {
            this.counter = startingValue;
        } else {
            this.counter = 0;  // Set to default (0000) if out of range
        }
        this.numberOfOverflows = 0;
    }

    // Method to get the total value as a formatted string
    public String total() {
        int dollars = counter / 100;
        int cents = counter % 100;
        return String.format("$%02d.%02d", dollars, cents);
    }

    // Method to increment the tens place
    public void incrementTens() {
        counter += 1000;  // Increment by 1000 for tens
        checkOverflow();
    }

    // Method to increment the ones place
    public void incrementOnes() {
        counter += 100;  // Increment by 100 for ones
        checkOverflow();
    }

    // Method to increment the tenths place
    public void incrementTenths() {
        counter += 10;  // Increment by 10 for tenths
        checkOverflow();
    }

    // Method to increment the hundredths place
    public void incrementHundredths() {
        counter++;  // Increment by 1 for hundredths
        checkOverflow();
    }

    // Method to check for overflow and reset digits accordingly
    private void checkOverflow() {
        if (counter > MAX_COUNTER) {
            counter = 0;  // Reset counter to 0000 if overflow occurs
            numberOfOverflows++;
        }
    }

    // Method to return the number of overflows
    public int getNumberOfOverflows() {
        return numberOfOverflows;
    }

    // Method to clear the counter and reset the overflow count
    public void clear() {
        this.counter = 0;
        this.numberOfOverflows = 0;
    }
}
