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

    private final Ramp ramp;

    /**
     * Car component
     */
    private final Car car;

    public TransportTruck(double enginePower, double width, double length, int capacity, double maxW, double maxL) {
        car = new Car(enginePower, width, length, "Transport Truck", Color.red, 2);
        storage = new LIFO<>(capacity, maxW, maxL, 2, car.getPosition(), car.getDirection(), car.getLength());
        ramp = new Ramp(70, 1);
    }

    public TransportTruck(Car car, int capacity, double maxW, double maxL) {
        this.car = car;
        storage = new LIFO<>(capacity, maxW, maxL, 2, car.getPosition(), car.getDirection(), car.getLength());
        ramp = new Ramp(70, 1);
    }

    // For an object to be a specific _Car_ storage truck, that has to be declared when creating the object.
    public void store(T item) {
        if (ramp.isFullyLowered() && item != this) {
            storage.store(item);
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
//        Vector2D offset = vehicle.getDirection().multiplyByScalar(vehicle.getLength() / 2 + storage.getPickUpRange());
//        return storage.remove(offset);
    }

    @Override
    public int getSize() {
        return storage.getSize();
    }

    @Override
    public void move() {
        if (ramp.isFullyRaised()) {
            car.move();
            storage.relocate(car.getPosition(), car.getDirection());
        }
    }

    @Override
    public void turnLeft() {
        if (ramp.isFullyRaised())
            car.turnLeft();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount) {
        car.brake(amount, findSpeedFactor());
    }

    @Override
    public boolean isMoving() {
        return car.getCurrentSpeed() > 0;
    }

    @Override
    public void startEngine() {
        if (ramp.isFullyRaised()) {
            car.startEngine();
        }
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    public double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
    }

    /**
     * Raise loading platform.
     * returns true if platform is at load position.
     */
    public boolean raiseRamp() {
        if (car.getCurrentSpeed() == 0) {
            ramp.raise();
        }
        return ramp.isFullyRaised();
    }

    /**
     * Lower loading platform to ground.
     * It's is only possible to lower when engine is off.
     * return true when platform is a 0 degree sensor.
     */
    public boolean lowerRamp() {
        if (car.getCurrentSpeed() == 0) {
            ramp.lower();
        }
        return ramp.isFullyLowered();
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
