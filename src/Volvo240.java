import java.awt.*;

/**
 * A class representing a Volvo240 car.
 */
public class Volvo240 implements Movable, Transportable, AuxTrim {

    /**
     * Trim factor, multiplier for speed factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Car component.
     */
    private final Car car;

    /**
     * Constructs a Volvo240 object with (hardcoded) presets for modelName, color, enginePower and nrDoors.
     */
    public Volvo240(double width, double length) {
        this.car = new Car(100, width, length, "Volvo240", Color.black, 4);
    }


    /**
     * Returns the speed factor of the Volvo240.
     * @return the speed factor of the Volvo240
     */
    private double findSpeedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
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
    @Override
    public Vector2D getDirection() {
        return car.getDirection();
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
}

