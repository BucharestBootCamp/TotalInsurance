package org.bootcamp.vehicle;

public class Bus extends Vehicle {
    private int numberOfSeats = 20;

    public Bus() {
        super();
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel) {
        super(age, numberOfMiles, isDiesel);
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel, int numberOfSeats) {
        super(age, numberOfMiles, isDiesel);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
