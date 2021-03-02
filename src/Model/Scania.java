package Model;

import java.awt.*;

/**
 * A movable truck with a movable ramp
 */
public class Scania extends Car implements IRampVehicle {

    /**
     * Ramp component.
     */
    private final Ramp platform;
    /**
     * Constructs a Model.Model.Scania truck object with the specified modelName, color, enginePower, nrDoors, width and length.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     * @param position Init Scania with startup position.
     */
    Scania(Vector2D position) {
        super(80, 3, 7, "Scania", Color.blue, 2, position);
        platform = new Ramp(70, 1);
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
    public void raise(double amount) {
        if (!isMoving()) {
            platform.raise(amount);
        }
    }

    /**
     * Lowers the ramp to its lowest position. Can not be done if the truck is moving.
     */
    public void lower(double amount) {
        if (!isMoving()) {
            platform.lower(amount);
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
        return platform.isFullyRaised();
    }

    /**
     * Returns true if the platform is fully lowered, false otherwise.
     * @return true if the platform is fully lowered, false otherwise.
     */
    public boolean isFullyLowered() {
        return platform.isFullyLowered();
    }

}
