package Model;

import java.awt.*;

/**
 * A movable truck with storage
 * @param <T> the things to store
 */
public class TransportTruck<T extends ITransportable> extends Car implements ITransporter<T>, ITransportable /*, Model.Model.Transportable, IStorageUnit<T>, AuxPlatform */ {

    /**
     * Storage component
     */
    private final LIFO<T> storage;

    /**
     * Model.Model.Ramp component
     */
    private final Ramp ramp;

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
        super(enginePower, width, length, "Transport Truck", Color.red, 2);
        storage = new LIFO<T>(capacity, maxW, maxL, 2, getPosition(), getDirection(), getLength());
        ramp = new Ramp(70, 1);
    }


    /**
     * Add an item to the storage.
     */
    public void store(T item) {
        if (ramp.isFullyLowered() && item != this) {
            storage.store(item);
        } else {
            System.err.println("Model.Model.Ramp is not down!");
        }
    }

    /**
     * Remove an item from the storage.
     * @return the removed item.
     */
    public T remove() {
        if (!ramp.isFullyLowered()) {
            throw new IllegalStateException("Model.Model.Ramp not fully lowered");
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
     * Returns the speed factor of the truck.
     * @return the speed factor of the truck.
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Raise loading platform.
     * It's is only possible to raise the ramp when engine is off.
     */
    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raiseFully();
        }
    }

    /**
     * Lower loading platform to ground.
     * It's is only possible to lower the ramp when engine is off.
     */
    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lowerFully();
        }
    }

    /**
     * Starts the truck by setting its speed to 0.1.
     */
    @Override
    public void startEngine() {
        if (ramp.isFullyRaised()) {
            super.startEngine();
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

    @Override
    public void move() {
        super.move();
        storage.relocate(getPosition(), getDirection());
    }

}
