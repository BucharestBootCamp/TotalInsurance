package org.bootcamp.controller;


import org.bootcamp.model.EnsuranceCalculationResult;
import org.bootcamp.service.VehicleEnsurancePolicyCalculatorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/")
public class MainController {

    private VehicleEnsurancePolicyCalculatorService calculatorService;
    private ResponseEntityUtils entityUtils;

    public MainController(VehicleEnsurancePolicyCalculatorService calculatorService, ResponseEntityUtils entityUtils) {
        this.calculatorService = calculatorService;
        this.entityUtils = entityUtils;
    }

    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String welcome() {
        return "<h1>Welcome to Total Insurance Andrei Oprisan</h1>";
    }

    @GetMapping(value = "calculate", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<EnsuranceCalculationResult> getAll() {
        List<EnsuranceCalculationResult> calculationResults = calculatorService.calculationResults();
        return calculationResults;
    }

    @GetMapping(value = "calculate/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_HTML_VALUE})
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Optional<EnsuranceCalculationResult> calculationResult = calculatorService.calculateById(id);

        return calculationResult.map(entityUtils::wrapResponseEntity)
                .orElseGet(entityUtils::getNotFoundResponseEntity);
    }
}
