package Model;

import java.awt.*;

/**
 * A class representing a Model.Model.Saab95 car.
 */

public class Saab95 extends Car implements ITurboVehicle {

    /**
     * True if turbo is on or not.
     */
    private boolean turboOn;

    /**
     * Constructs a Model.Model.Saab95 object with (hardcoded) presets for modelName, color, enginePower and nrDoors. Initializes
     * turboOn to false.
     */
    Saab95(Vector2D position) {
        super(100, 2, 5, "Saab95", Color.red, 4, position);
        turboOn = false;
    }

    /**
     * Sets turboOn to true.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets turboOn to false.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Returns the value of turboOn.
     * @return the value of turboOn
     */
    public boolean getTurboOn() {
        return turboOn;
    }

    /**
     * Returns the turbo factor of the Model.Model.Saab95.
     * @return the turbo factor of the Model.Model.Saab95
     */
    private double findTurboFactor() {
        if (turboOn) return 1.3;
        return 1;
    }

    /**
     * Returns the speed factor of the Model.Model.Saab95.
     * @return the speed factor of the Model.Model.Saab95
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01 * findTurboFactor();
    }


}

