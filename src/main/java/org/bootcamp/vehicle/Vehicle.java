package org.bootcamp.vehicle;

public abstract class Vehicle {
    private int age;
    private long numberOfMiles;
    private boolean isDiesel;

    protected Vehicle() {
    }

    protected Vehicle(int age, long numberOfMiles, boolean isDiesel) {
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public int getAge() {
        return age;
    }

    public long getNumberOfMiles() {
        return numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumberOfMiles(long numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    public void setDiesel(boolean diesel) {
        isDiesel = diesel;
    }
}
