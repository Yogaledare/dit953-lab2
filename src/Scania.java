import java.awt.*;

/**
 * A movable truck with a movable ramp
 */
public class Scania extends Car implements Transportable {

    /**
     * Ramp component.
     */
    private final Ramp ramp;

    /**
     * Constructs a Scania truck object with the specified modelName, color, enginePower, nrDoors, width and length.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     * @param enginePower the power of the engine.
     * @param width the width of the car.
     * @param length the length of the car.
     * @param modelName the model name of the car.
     * @param color the color of the car.
     * @param nrDoors the number of doors of the car.
     */
    public Scania(double enginePower, double width, double length, String modelName, Color color, int nrDoors) {
        super(enginePower, width, length, modelName, color, nrDoors, new Vector2D(0, 0));
        ramp = new Ramp(70, 1);
    }


    /**
     * Returns the speed factor of the truck.
     * @return the speed factor of the truck.
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Raises the ramp to its topmost position. Can not be done if the truck is moving.
     */
    public void raise() {
        if (!isMoving()) {
            ramp.raise();
        }
    }

    /**
     * Lowers the ramp to its lowest position. Can not be done if the truck is moving.
     */
    public void lower() {
        if (!isMoving()) {
            ramp.lower();
        }
    }


    /**
     * Starts the truck by setting its speed to 0.1.
     */
    @Override
    public void startEngine() {
        if (isFullyLowered()) {
            super.startEngine();
        }
    }


    /**
     * Returns true if the platform is fully raised, false otherwise.
     * @return true if the platform is fully raised, false otherwise.
     */
    public boolean isFullyRaised() {
        return ramp.isFullyRaised();
    }

    /**
     * Returns true if the platform is fully lowered, false otherwise.
     * @return true if the platform is fully lowered, false otherwise.
     */
    public boolean isFullyLowered() {
        return ramp.isFullyLowered();
    }

}
