/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ca.solent.devops.stevedore.service.model;

/**
 *
 * @author Quake
 */
public class fuelService {

    private double currentFuelLevel;
    private double FuelCapability;

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public void setFuelCapability(double FuelCapability) {
        this.FuelCapability = FuelCapability;
    }
   
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public double getFuelCapability() {
        return FuelCapability;
    }
 
}
