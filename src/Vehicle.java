/**
 * @author Niklas  Axelsson < name @ student.gu.se>
 * @author vehiclel    Stewart <gusstewca@student.gu.se>
 * @author Marcus  Uppström <gusuppma@student.gu.se>
 * @version 0.1                 (current version number of program)
 */

import java.awt.*;


/**
 * An abstract class representing a generic vehicle.
 */
public class Vehicle implements Positionable{

    /**
     * Current speed valid interval from 0 to Engine power
     */
    private double currentSpeed;

    /**
     * Engine power affects top speed, acceleration and deceleration
     */
    private final double enginePower;

    /**
     * Direction vector of the vehicle
     */
    private Vector2D direction;
    /**
     * Position vector of the vehicle
     */
    private Vector2D position;

    /**
     * Constructs a vehicle object with the specified modelYear, color, enginePower and nrDoors.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     * @param enginePower the engine power of the vehicle
     */
    public Vehicle(double enginePower) {
        this.enginePower = enginePower;
        this.direction = new Vector2D(0, 1);
        stopEngine();
    }

    /**
     * Returns the enginePower of the vehicle.
     * @return the enginePower of the vehicle
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Returns the current speed of the vehicle. The speed has a value between 0 and the enginePower of the vehicle.
     * @return the current speed of the vehicle.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Starts the vehicle by setting currentSpeed to 0.1.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the vehicle by setting currentSpeed to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Increases the speed of the vehicle by the speed factor of the vehicle times a scale factor (amount).
     * The speed cannot exceed the enginePower of the vehicle.
     * @param amount how much the speed should increase for every move.
     */
    private void incrementSpeed(double amount) {
        if (currentSpeed != 0) {
            currentSpeed = Vector2D.clamp(getCurrentSpeed() + findSpeedFactor() * amount, 0, enginePower);
        }
    }

    /**
     * Decreases the speed of the vehicle by the speed factor of the vehicle times a scale factor (amount).
     * The speed can not go below 0.
     * @param amount how much the speed should decrease for every move.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Vector2D.clamp(getCurrentSpeed() - findSpeedFactor() * amount, 0, enginePower);
    }

    /**
     * Increases the speed of the vehicle by calling incrementSpeed with amount as argument.
     * Amount is clamped to the interval [0, 1].
     * @param amount a value between 0 and 1 representing how much the gas is pressed
     */
    public void gas(double amount) {
        incrementSpeed(Vector2D.clamp(amount, 0, 1));
    }

    /**
     * Decreases the speed of the vehicle by calling decrementSpeed with amount as argument.
     * Amount is clamped to the interval [0, 1].
     * @param amount a value between 0 and 1 representing how much the brake is pressed
     */
    public void brake(double amount) {
        decrementSpeed(Vector2D.clamp(amount, 0, 1));
    }

    /**
     * Moves the vehicle in its current direction by length = currentSpeed.
     */
    public void move() {
        Vector2D step = direction.multiplyByScalar(currentSpeed);
        position = position.plus(step);
    }

    /**
     * Turns the vehicle 90 degrees to the left.
     */
    public void turnLeft() {
        direction = direction.rotateCC(Math.PI / 2);
    }

    /**
     * Turns the vehicle 90 degrees to the right.
     */
    public void turnRight() {
        direction = direction.rotateCC(-Math.PI / 2);
    }

    /**
     * Returns the direction vector of the vehicle.
     * @return the direction vector of the vehicle
     */
    public Vector2D getDirection() {
        return direction;
    }

}

