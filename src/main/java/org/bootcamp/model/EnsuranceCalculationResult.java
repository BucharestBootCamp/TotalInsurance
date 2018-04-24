package org.bootcamp.model;

public class EnsuranceCalculationResult {
    private String id;
    private int totalPolicyCost;

    public EnsuranceCalculationResult() {
    }

    public EnsuranceCalculationResult(String id, int totalPolicyCost) {
        this.id = id;
        this.totalPolicyCost = totalPolicyCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTotalPolicyCost() {
        return totalPolicyCost;
    }

    public void setTotalPolicyCost(int totalPolicyCost) {
        this.totalPolicyCost = totalPolicyCost;
    }
}
