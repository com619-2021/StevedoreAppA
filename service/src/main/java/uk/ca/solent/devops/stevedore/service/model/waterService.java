
package uk.ca.solent.devops.stevedore.service.model;

/**
 *
 * @author Quake
 */
public class waterService {
    private double currentWaterLevel;
    private double waterCapability;

    public void setCurrentWaterLevel(double currentWaterLevel) {
        this.currentWaterLevel = currentWaterLevel;
    }

    public void setWaterCapibility(double waterCapability) {
        this.waterCapability = waterCapability;
    }

    public double getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    public double getWaterCapability() {
        return waterCapability;
    }
}

