package org.bootcamp.util;

import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class ConversionUtils {
    public Vehicle getVehicleType(String vehicleTypeName, int age, long numberOfMiles, boolean isDiesel) {
        String carClassName = Car.class.getSimpleName().toUpperCase();
        String busClassName = Bus.class.getSimpleName().toUpperCase();
        String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if (vehicleTypeName.equals(carClassName)) {
            return new Car(age, numberOfMiles, isDiesel);
        }

        if (vehicleTypeName.equals(busClassName)) {
            return new Bus(age, numberOfMiles, isDiesel);
        }

        if (vehicleTypeName.equals(tipperClassName)) {
            return new Tipper(age, numberOfMiles, isDiesel);
        }

        return null;
    }
}
