/**
 * @author Niklas  Axelsson < name @ student.gu.se>
 * @author Carl    Stewart <gusstewca@student.gu.se>
 * @author Marcus  Uppström <gusuppma@student.gu.se>
 * @version 0.1                 (current version number of program)
 */

import java.awt.*;


/**
 * An abstract class representing a generic car.
 */
public abstract class Vehicle implements Movable, Storable {

    /**
     * Car model
     */
    private final String modelName;

    /**
     * Color of car
     */
    private Color color;

    /**
     * Current speed valid interval from 0 to Engine power
     */
    private double currentSpeed;

    /**
     * Engine power affects top speed, acceleration and deceleration
     */
    private final double enginePower;

    /**
     * Number of doors
     */
    private final int nrDoors;

    /**
     * Position vector of the car
     */
    private Vector2D position;

    /**
     * Direction vector of the car
     */
    private Vector2D direction;

    /**
     * Constructs a Car object with the specified modelYear, color, enginePower and nrDoors.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     * @param modelName the model name of the car
     * @param color the color of the car
     * @param enginePower the engine power of the car
     * @param nrDoors the number of doors of the car
     */
    public Vehicle(String modelName, Color color, double enginePower, int nrDoors) {
        this.modelName = modelName;
        this.color = color;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.position = new Vector2D(0, 0);
        this.direction = new Vector2D(0, 1);
        stopEngine();
    }

    /**
     * Returns the number of doors of the car.
     * @return the number of doors of the car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the enginePower of the car.
     * @return the enginePower of the car
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Returns the current speed of the car. The speed has a value between 0 and the enginePower of the car.
     * @return the current speed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the color of the car.
     * @return the color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the modelName of the car.
     * @return the modelName of the car
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the color of car.
     * @param clr the new color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the car by setting currentSpeed to 0.1.
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the car by setting currentSpeed to 0.
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Determines the speed factor of the car.
     * @return the speed factor of the car
     */
    public abstract double findSpeedFactor();

    /**
     * Increases the speed of the car by the speed factor of the car times a scale factor (amount).
     * The speed cannot exceed the enginePower of the car.
     * @param amount how much the speed should increase for every move.
     */
    private void incrementSpeed(double amount) {
        if (currentSpeed != 0) {
            currentSpeed = Vector2D.clamp(getCurrentSpeed() + findSpeedFactor() * amount, 0, enginePower);
        }
    }

    /**
     * Decreases the speed of the car by the speed factor of the car times a scale factor (amount).
     * The speed can not go below 0.
     * @param amount how much the speed should decrease for every move.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Vector2D.clamp(getCurrentSpeed() - findSpeedFactor() * amount, 0, enginePower);
    }

    /**
     * Increases the speed of the car by calling incrementSpeed with amount as argument.
     * Amount is clamped to the interval [0, 1].
     * @param amount a value between 0 and 1 representing how much the gas is pressed
     */
    public void gas(double amount) {
        incrementSpeed(Vector2D.clamp(amount, 0, 1));
    }

    /**
     * Decreases the speed of the car by calling decrementSpeed with amount as argument.
     * Amount is clamped to the interval [0, 1].
     * @param amount a value between 0 and 1 representing how much the brake is pressed
     */
    public void brake(double amount) {
        decrementSpeed(Vector2D.clamp(amount, 0, 1));
    }

    /**
     * Moves the car in its current direction by length = currentSpeed.
     */
    public void move() {
        Vector2D step = direction.multiplyByScalar(currentSpeed);
        position = position.plus(step);
    }

    /**
     * Turns the car 90 degrees to the left.
     */
    public void turnLeft() {
        direction = direction.rotateCC(Math.PI / 2);
    }

    /**
     * Turns the car 90 degrees to the right.
     */
    public void turnRight() {
        direction = direction.rotateCC(-Math.PI / 2);
    }


    public void setPosition(Vector2D position) {
        this.position = position;
    }

    /**
     * Returns the position vector of the car.
     * @return the position vector of the car
     */
    public Vector2D getPosition() {
        return position;
    }

    /**
     * Returns the direction vector of the car.
     * @return the direction vector of the car
     */
    public Vector2D getDirection() {
        return direction;
    }

}
