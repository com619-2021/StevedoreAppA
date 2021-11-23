/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ca.solent.devops.stevedore.service.model;

public class foodService {
    private double currentFoodLevel;
    private double foodCapability;
    public void setCurrentFoodLevel(double currentFoodLevel) {
        this.currentFoodLevel = currentFoodLevel;
    }

    public void setFoodCapability(double foodCapability) {
        this.foodCapability = foodCapability;
    }


    public double getCurrentFoodLevel() {
        return currentFoodLevel;
    }

    public double getFoodCapability() {
        return foodCapability;
    }

 
}
