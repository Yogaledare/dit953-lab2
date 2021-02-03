import java.awt.*;

public class Scania implements Movable, Storable, Positionable, AuxPlatform {

    private final Car car;
    private final Ramp ramp;

    /**
     * Constructs a Scania truck object with the specified modelName, color, enginePower, nrDoors, width and length.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     *
     * @param enginePower the power of the engine
     * @param modelName   the model name of the car
     * @param color       the color of the car
     * @param nrDoors     the number of doors of the car
     * @param width       the width of the car
     * @param length      the length of the car
     */
    public Scania(double enginePower, String modelName, Color color, int nrDoors, double width, double length) {
        car = new Car(enginePower, modelName, color, nrDoors, width, length);
        ramp = new Ramp(70, 1);
    }

    public Scania(Car car) {
        this.car = car;
        ramp = new Ramp(70, 1);
    }

    public double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {
        if(ramp.fullyRaised())
            car.turnLeft();
    }

    @Override
    public void turnRight() {
        if(ramp.fullyRaised())
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
    public boolean raise() {
        if (car.getCurrentSpeed() == 0) {
            ramp.raise();
        }
        return ramp.fullyRaised();
    }

    @Override
    public boolean lower() {
        if (car.getCurrentSpeed() == 0) {
            ramp.lower();
        }
        return ramp.fullyLowered();
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
