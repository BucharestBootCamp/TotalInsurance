package org.bootcamp.vehicle;

public class Car extends Vehicle {
    private String transmision = "manual";

    public Car() {
        super();
    }

    public Car(int age, long numberOfMiles, boolean isDiesel) {
        super(age, numberOfMiles, isDiesel);
    }

    public Car(int age, long numberOfMiles, boolean isDiesel, String transmision) {
        super(age, numberOfMiles, isDiesel);
        this.transmision = transmision;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
}
