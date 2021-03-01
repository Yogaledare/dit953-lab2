package Model;

import java.awt.*;

/**
 * A class representing a Model.Model.Volvo240 car.
 */
public class Volvo240 extends Car implements ITrim {

    /**
     * Trim factor, multiplier for speed factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Model.Model.Volvo240 object with (hardcoded) presets for modelName, color, enginePower and nrDoors.
     */
    Volvo240(Vector2D position) {
        super(100, 2, 5, "Volvo240", Color.black, 4, position);
    }

    /**
     * Returns the speed factor of the Model.Model.Volvo240.
     * @return the speed factor of the Model.Model.Volvo240
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


}

