package org.bootcamp.dao;

public class VehicleInfo {
    private String id;
    private String vehicleTypeName;
    private String formulaTypeName;
    private int age;
    private long numberOfMiles;
    private boolean isDiesel;

    public VehicleInfo() {
    }

    public VehicleInfo(String id, String vehicleTypeName, String formulaTypeName, int age, long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.formulaTypeName = formulaTypeName;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public String getFormulaTypeName() {
        return formulaTypeName;
    }

    public void setFormulaTypeName(String formulaTypeName) {
        this.formulaTypeName = formulaTypeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNumberOfMiles() {
        return numberOfMiles;
    }

    public void setNumberOfMiles(long numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public void setDiesel(boolean diesel) {
        isDiesel = diesel;
    }
}
