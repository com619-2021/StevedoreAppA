/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ca.solent.devops.stevedore.service.model;

/**
 *
 * @author Quake
 */
public class wasteService {
     private double currentWasteLevel;
    private double wasteCapability;

    public double getCurrentWasteLevel() {
        return currentWasteLevel;
    }

    public double getWasteCapability() {
        return wasteCapability;
    }

    public void setCurrentWasteLevel(double currentWasteLevel) {
        this.currentWasteLevel = currentWasteLevel;
    }

    public void setWasteCapability(double wasteCapability) {
        this.wasteCapability = wasteCapability;
    }
}
