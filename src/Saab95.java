import java.awt.*;

/**
 * A class representing a Saab95 car.
 */

public class Saab95 implements Movable, Transportable, AuxTurbo{

    /**
     * True if turbo is on or not.
     */
    private boolean turboOn;

    /**
     * Car component.
     */
    private final Car car;

    /**
     * Constructs a Saab95 object with (hardcoded) presets for modelName, color, enginePower and nrDoors. Initializes
     * turboOn to false.
     */
    public Saab95(double width, double length) {
        this.car = new Car(100, width, length, "Saab95", Color.red, 2);
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
     * Returns the turbo factor of the Saab95.
     * @return the turbo factor of the Saab95
     */
    private double findTurboFactor() {
        if (turboOn) return 1.3;
        return 1;
    }

    /**
     * Returns the speed factor of the Saab95.
     * @return the speed factor of the Saab95
     */
    private double findSpeedFactor() {
        return car.getEnginePower() * 0.01 * findTurboFactor();
    }

    /**
     * Number of doors
     * @return returns numbers of doors the car have.
     */
    public int getNoOfDoors() {
        return car.getNoOfDoors();
    }

    /**
     * Current speed of Saab 95
     * @return current speed.
     */
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    /**
     * Engine power, relates to max speed.
     * @return get the enginepower. 
     */
    public double getEnginePower() {
        return car.getEnginePower();
    }

    /**
     * Moves the truck in its current direction by length = current speed.
     */
    @Override
    public void move() {
        car.move();
    }

    /**
     * Turns the car 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    /**
     * Turns the car 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        car.turnRight();
    }

    /**
     * Increases the speed of the car by a fraction between 0 and 1 of its max acceleration capacity.
     * @param amount a value between 0 and 1 representing how much the gas is pressed.
     *               If outside this interval, the value will be clamped.
     */
    @Override
    public void gas(double amount) {
        car.gas(amount, findSpeedFactor());
    }

    /**
     * Decreases the speed of the car by a fraction between 0 and 1 of its max deceleration capacity.
     * @param amount a value between 0 and 1 representing how much the brake is pressed.
     *               If outside this interval, the value will be clamped.
     */
    @Override
    public void brake(double amount) {
        car.brake(amount, findSpeedFactor());
    }

    /**
     * Returns true if the speed of the car is nonzero and false if it is zero.
     * @return true if the speed of the car is nonzero and false if it is zero.
     */
    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    /**
     * Starts the car by setting its speed to 0.1.
     */
    @Override
    public void startEngine() {
        car.startEngine();
    }

    /**
     * Stops the car by setting its speed to 0.
     */
    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    /**
     * Returns the width of the car.
     * @return the width of the car.
     */
    @Override
    public double getWidth() {
        return car.getWidth();
    }

    /**
     * Returns the length of the car. 
     * @return the length of the car. 
     */
    @Override
    public double getLength() {
        return car.getLength();
    }

    /**
     * Sets the position of the car. 
     * @param position the new position of the car. 
     */
    @Override
    public void setPosition(Vector2D position) {
        car.setPosition(position);
    }

    /**
     * Returns the position of the car. 
     * @return the position of the car. 
     */
    @Override
    public Vector2D getPosition() {
        return car.getPosition();
    }

    /**
     * Sets the direction of the car
     * @param direction the new direction of the car.
     */
    @Override
    public void setDirection(Vector2D direction) {
        car.setDirection(direction);
    }

    /**
     * Returns the direction of the car.
     * @return the direction of the car.
     */
    public Vector2D getDirection() {
        return car.getDirection();
    }
}

