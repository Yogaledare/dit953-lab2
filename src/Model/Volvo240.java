package Model;

import java.awt.*;

/**
 * A class representing a Model.Model.Volvo240 car.
 */
public class Volvo240 extends Car implements Transportable, ITrim {

    /**
     * Trim factor, multiplier for speed factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Model.Model.Volvo240 object with (hardcoded) presets for modelName, color, enginePower and nrDoors.
     */
    public Volvo240(double width, double length) {
        super(100, width, length, "Volvo240", Color.black, 4);
    }

    /**
     * Returns the speed factor of the Model.Model.Volvo240.
     * @return the speed factor of the Model.Model.Volvo240
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}

