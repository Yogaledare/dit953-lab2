import java.awt.*;

/**
 * A class representing a Volvo240 car.
 */
public class Volvo240 implements Movable, Transportable/*Positionable, Storable, Movable, AuxTrim*/ {

    /**
     * Trim factor, multiplier for speed factor
     */
    private final static double trimFactor = 1.25;

    private Car car;

    /**
     * Constructs a Volvo240 object by calling its parent constructor with (hardcoded) presets for modelName, color,
     * enginePower and nrDoors.
     */
    public Volvo240(double width, double length) {
        this.car = new Car(100, "Volvo240", Color.black, 4, width, length);
    }


    /**
     * Returns the speed factor of the Volvo240.
     * @return the speed factor of the Volvo240
     */

    private double findSpeedFactor() {
        return car.getEnginePower() * 0.01 * trimFactor;
    }


    @Override
    public void move() {
        car.move();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void gas(double amount, double speedFactor) {
        car.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount, double speedFactor) {
        car.brake(amount, findSpeedFactor());
    }

    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    @Override
    public void setPosition(Vector2D position) {
        car.setPosition(position);
    }

    @Override
    public Vector2D getPosition() {
        return car.getPosition();
    }

    @Override
    public double getWidth() {
        return car.getWidth();
    }

    @Override
    public double getLength() {
        return car.getLength();
    }
}


/*    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }*/

