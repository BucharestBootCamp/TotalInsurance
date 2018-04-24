package org.bootcamp.service;

import org.bootcamp.service.Formula;
import org.bootcamp.vehicle.Vehicle;
import org.springframework.stereotype.Component;

@Component
class EnsurancePolicyCalculator {
    public int calculateEnsurancePolicy(Vehicle vehicle, Formula formula) {
        return formula.calculate(vehicle);
    }
}
