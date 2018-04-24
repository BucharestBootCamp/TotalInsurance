package org.bootcamp.service;

import org.bootcamp.dao.VehicleDao;
import org.bootcamp.model.EnsuranceCalculationResult;
import org.bootcamp.dao.VehicleInfo;
import org.bootcamp.util.ConversionUtils;
import org.bootcamp.vehicle.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleEnsurancePolicyCalculatorService {
    private VehicleDao vehicleDao;
    private EnsurancePolicyCalculator ensurancePolicyCalculator;
    private ConversionUtils conversionUtils;

    public VehicleEnsurancePolicyCalculatorService(VehicleDao vehicleDao,
                                                   EnsurancePolicyCalculator ensurancePolicyCalculator,
                                                   ConversionUtils conversionUtils) {
        this.vehicleDao = vehicleDao;
        this.ensurancePolicyCalculator = ensurancePolicyCalculator;
        this.conversionUtils = conversionUtils;
    }

    public List<EnsuranceCalculationResult> calculationResults() {
        List<EnsuranceCalculationResult> calculationResults = new ArrayList<>();

        List<VehicleInfo> infoList = vehicleDao.getAllVehicles();

        for (int i = 0; i < infoList.size(); i++) {
            VehicleInfo info = infoList.get(i);

            Vehicle vehicle = conversionUtils.getVehicleType(info.getVehicleTypeName(), info.getAge(), info.getNumberOfMiles(), info.isDiesel());
            Formula formula = Formula.valueOf(info.getFormulaTypeName());

            int totalPolicyCost = ensurancePolicyCalculator.calculateEnsurancePolicy(vehicle, formula);

            EnsuranceCalculationResult result = new EnsuranceCalculationResult(info.getId(), totalPolicyCost);

            calculationResults.add(result);
        }

        return calculationResults;
    }

    public Optional<EnsuranceCalculationResult> calculateById(String vehicleId) {
        List<EnsuranceCalculationResult> calculationResults = this.calculationResults();

        return calculationResults.stream()
                .filter(ensuranceCalculationResult -> ensuranceCalculationResult.getId().equals(vehicleId))
                .findFirst();
    }

}
