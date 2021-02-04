import java.awt.*;

/**
 * A movable truck with storage
 * @param <T> the things to store
 */
public class TransportTruck<T extends Transportable> implements Movable, Transporter<T>, Transportable /*, Transportable, IStorageUnit<T>, AuxPlatform */ {

    /**
     * Storage component
     */
    private final LIFO<T> storage;

    /**
     * Ramp component
     */
    private final Ramp ramp;

    /**
     * Car component
     */
    private final Car car;

    /**
     * Constructs a Transport truck with the specified enginePower, width length, capacity and max dimensions for
     * the stored units (witdth and length).
     * @param enginePower the engine power of the truck.
     * @param width the width of the truck.
     * @param length the length of the truck.
     * @param capacity the storage capacity (in units) of the truck.
     * @param maxW max width of a stored item.
     * @param maxL max length of a stored item.
     */
    public TransportTruck(double enginePower, double width, double length, int capacity, double maxW, double maxL) {
        car = new Car(enginePower, width, length, "Transport Truck", Color.red, 2);
        storage = new LIFO<>(capacity, maxW, maxL, 2, car.getPosition(), car.getDirection(), car.getLength());
        ramp = new Ramp(70, 1);
    }

    /**
     * Constructs a transport truck object from a Car object and a storage capacity and max dimensions of stored items
     * (width and length)
     * @param car A car object from which to build the truck object.
     * @param capacity the storage capacity (in units) of the truck.
     * @param maxW max width of a stored item.
     * @param maxL max length of a stored item.
     */
    public TransportTruck(Car car, int capacity, double maxW, double maxL) {
        this.car = car;
        storage = new LIFO<>(capacity, maxW, maxL, 2, car.getPosition(), car.getDirection(), car.getLength());
        ramp = new Ramp(70, 1);
    }

    /**
     * Add an item to the storage.
     */
    public void store(T item) {
        if (ramp.isFullyLowered() && item != this) {
            storage.store(item);
        } else {
            System.err.println("Ramp is not down!");
        }
    }

    /**
     * Remove an item from the storage.
     * @return the removed item.
     */
    public T remove() {
        if (!ramp.isFullyLowered()) {
            throw new IllegalStateException("Ramp not fully lowered");
        }
        return storage.remove();
    }

    /**
     * Returns the number of stored items.
     * @return the number of stored items.
     */
    @Override
    public int getSize() {
        return storage.getSize();
    }

    /**
     * Moves the truck in its current direction by length = current speed.
     */
    @Override
    public void move() {
        car.move();
        storage.relocate(car.getPosition(), car.getDirection());
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
        return car.getCurrentSpeed() > 0;
    }

    /**
     * Starts the truck by setting its speed to 0.1.
     */
    @Override
    public void startEngine() {
        if (ramp.isFullyRaised()) {
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
     * Returns the speed factor of the truck.
     * @return the speed factor of the truck.
     */
    private double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
    }

    /**
     * Raise loading platform.
     * It's is only possible to raise the ramp when engine is off.
     */
    public void raiseRamp() {
        if (car.getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    /**
     * Lower loading platform to ground.
     * It's is only possible to lower the ramp when engine is off.
     */
    public void lowerRamp() {
        if (car.getCurrentSpeed() == 0) {
            ramp.lower();
        }
    }

    /**
     * Returns true if the ramp is fully raised, false otherwise.
     * @return true if the ramp is fully raised, false otherwise.
     */
    public boolean isFullyRaised() {
        return ramp.isFullyRaised();
    }

    /**
     * Returns true if the ramp is fully lowered, false otherwise.
     * @return true if the ramp is fully lowered, false otherwise.
     */
    public boolean isFullyLowered() {
        return ramp.isFullyLowered();
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
        return car.getDirection();
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
