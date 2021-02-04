import java.awt.*;

/**
 * A movable truck with a movable ramp
 */
public class Scania implements Movable, Transportable {

    /**
     * Car component.
     */
    private final Car car;

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
        car = new Car(enginePower, width, length, modelName, color, nrDoors, new Vector2D(0, 0));
        ramp = new Ramp(70, 1);
    }

    /**
     * Constructs Scania truck object from a Car object.
     * @param car A Car object from which to construct the Scania object.
     */
    public Scania(Car car) {
        this.car = car;
        ramp = new Ramp(70, 1);
    }

    /**
     * Returns the speed factor of the truck.
     * @return the speed factor of the truck.
     */
    private double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
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

    /**
     * Moves the truck in its current direction by length = current speed.
     */
    @Override
    public void move() {
        car.move();
    }

    /**
     * Turns the truck 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    /**
     * Turns the truck 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        car.turnRight();
    }

    /**
     * Increases the speed of the truck by a fraction between 0 and 1 of its max acceleration capacity.
     * @param amount a value between 0 and 1 representing how much the gas is pressed.
     *               If outside this interval, the value will be clamped.
     */
    @Override
    public void gas(double amount) {
        car.gas(amount, findSpeedFactor());
    }

    /**
     * Decreases the speed of the truck by a fraction between 0 and 1 of its max deceleration capacity.
     * @param amount a value between 0 and 1 representing how much the brake is pressed.
     *               If outside this interval, the value will be clamped.
     */
    @Override
    public void brake(double amount) {
        car.brake(amount, findSpeedFactor());
    }

    /**
     * Returns true if the speed of the truck is nonzero and false if it is zero.
     * @return true if the speed of the truck is nonzero and false if it is zero.
     */
    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    /**
     * Starts the truck by setting its speed to 0.1.
     */
    @Override
    public void startEngine() {
        if (isFullyLowered()) {
            car.startEngine();
        }
    }

    /**
     * Stops the truck by setting its speed to 0.
     */
    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    /**
     * Sets the direction of the truck.
     * @param direction the new direction.
     */
    @Override
    public void setDirection(Vector2D direction) {
        car.setDirection(direction);
    }

    /**
     * Returns the direction of the truck.
     * @return the direction of the truck.
     */
    @Override
    public Vector2D getDirection() {
        return null;
    }

    /**
     * Sets the position of the truck.
     * @param position the new position.
     */
    @Override
    public void setPosition(Vector2D position) {
        car.setPosition(position);
    }

    /**
     * Returns the position of the truck.
     * @return the position of the truck.
     */
    @Override
    public Vector2D getPosition() {
        return car.getPosition();
    }

    /**
     * Returns the width of the truck.
     * @return the width of the truck.
     */
    @Override
    public double getWidth() {
        return car.getWidth();
    }

    /**
     * Returns the length of the truck.
     * @return the length of the truck.
     */
    @Override
    public double getLength() {
        return car.getLength();
    }
}
