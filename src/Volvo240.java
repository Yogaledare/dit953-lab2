import java.awt.*;

/**
 * A class representing a Volvo240 car.
 */
public class Volvo240 extends Car implements AuxTrim {

    /**
     * Trim factor, multiplier for speed factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Volvo240 object by calling its parent constructor with (hardcoded) presets for modelName, color,
     * enginePower and nrDoors.
     */
    public Volvo240() {
        super("Volvo240", Color.black, 100, 4);
    }

    /**
     * Returns the speed factor of the Volvo240.
     * @return the speed factor of the Volvo240
     */
    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
