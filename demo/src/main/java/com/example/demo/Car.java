package com.example.demo;

public class Car {
    private int cityMpg;
    private String vehicleClass;
    private int combinationMpg;
    private int cylinders;
    private double displacement;
    private String drive;
    private String fuelType;
    private int highwayMpg;
    private String make;
    private String model;
    private String transmission;
    private int year;

    // Constructor
    public Car(int cityMpg, String vehicleClass, int combinationMpg, int cylinders, double displacement, String drive, String fuelType, int highwayMpg, String make, String model, String transmission, int year) {
        this.cityMpg = cityMpg;
        this.vehicleClass = vehicleClass;
        this.combinationMpg = combinationMpg;
        this.cylinders = cylinders;
        this.displacement = displacement;
        this.drive = drive;
        this.fuelType = fuelType;
        this.highwayMpg = highwayMpg;
        this.make = make;
        this.model = model;
        this.transmission = transmission;
        this.year = year;
    }

    public int getCityMpg() {
        return cityMpg;
    }

    public void setCityMpg(int cityMpg) {
        this.cityMpg = cityMpg;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public int getCombinationMpg() {
        return combinationMpg;
    }

    public void setCombinationMpg(int combinationMpg) {
        this.combinationMpg = combinationMpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getHighwayMpg() {
        return highwayMpg;
    }

    public void setHighwayMpg(int highwayMpg) {
        this.highwayMpg = highwayMpg;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBriefDescription() {
        return String.format("Description: The %s %s is a %s %s made in %d. It has a %d-cylinder %s engine with a displacement of %.2fL, featuring %d city MPG and %d highway MPG.",
                make, model, year, vehicleClass, year, cylinders, fuelType, displacement, cityMpg, highwayMpg);
    }



    // Override toString method
    @Override
    public String toString() {
        return String.format("Year: %d\nMake: %s\nModel: %s\nClass: %s\nFuel Type: %s\nTransmission: %s\nCylinders: %d\nDisplacement: %.2f\nDrive: %s\nCity MPG: %d\nHighway MPG: %d\nCombination MPG: %d",
                year, make, model, vehicleClass, fuelType, transmission, cylinders, displacement, drive, cityMpg, highwayMpg, combinationMpg);
    }
}
