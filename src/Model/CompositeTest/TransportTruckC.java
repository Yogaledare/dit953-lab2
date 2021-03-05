/*
package Model.CompositeTest;


import Model.*;

import java.awt.*;

*/
/**
 * A movable truck with storage
 * @param <T> the things to store
 *//*

public class TransportTruckC<T extends ITransportable> extends Car implements ITransporter<T>, ITransportable, IRampVehicle {

    */
/**
     * Storage component
     *//*

    private final LIFO<T> storage;

    */
/**
     * Ramp component
     *//*

    private final Ramp ramp;

    */
/**
     * Constructs a Transport truck with the specified enginePower, width length, capacity and max dimensions for
     * the stored units (witdth and length).
     * @param capacity the storage capacity (in units) of the truck.
     * @param maxW max width of a stored item.
     * @param maxL max length of a stored item.
     *//*

    public TransportTruckC(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, int capacity, double maxW, double maxL) {
        super(position, direction, currentSpeed, engineOn,
                120, 4, 10, "Transport Truck", Color.pink, 2);
        storage = new LIFO<T>(capacity, maxW, maxL, 2, getPosition(), getDirection(), getLength());
        ramp = new Ramp(70, 1);
    }

    public TransportTruckC(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, LIFO<T> storage, Ramp ramp) {
        super(position, direction, currentSpeed, engineOn,
                120, 4, 10, "Transport Truck", Color.pink, 2);
        this.storage = storage;
        this.ramp = ramp;
    }

    public TransportTruckC(TransportTruck<T> truck){
        super(truck.getPosition(), truck.getDirection(), truck.getCurrentSpeed(), truck.isEngineOn(),
                120, 4, 10, "Transport Truck", Color.pink, 2);
        storage = truck.storage;
        ramp = truck.ramp;
    }

    */
/**
     * Add an item to the storage.
     *//*

    public void store(T item) {
        if (ramp.isFullyLowered() && item != this) {
            storage.store(item);
        } else {
            System.err.println("Ramp is not down!");
        }
    }

    */
/**
     * Remove an item from the storage.
     * @return the removed item.
     *//*

    public T remove() {
        if (!ramp.isFullyLowered()) {
            throw new IllegalStateException("Ramp not fully lowered");
        }
        return storage.remove();
    }

    */
/**
     * Returns the number of stored items.
     * @return the number of stored items.
     *//*

    @Override
    public int getSize() {
        return storage.getSize();
    }

    */
/**
     * Returns the speed factor of the truck.
     * @return the speed factor of the truck.
     *//*

    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    */
/**
     * Raise loading platform.
     * It's is only possible to raise the ramp when engine is off.
     *//*

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raiseFully();
        }
    }

    */
/**
     * Lower loading platform to ground.
     * It's is only possible to lower the ramp when engine is off.
     *//*

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lowerFully();
        }
    }

    */
/**
     * Starts the truck by setting its speed to 0.1.
     *//*

    @Override
    public IRampVehicle startEngine() {
        if (ramp.isFullyRaised()) {
            double speed = 0;
            if(!isEngineOn())
                speed = 0.1;
            return new TransportTruck<T>(getPosition(), getDirection(), speed, true, storage, ramp);
        }
        return new TransportTruck<T>(this);
    }

    @Override
    public IRampVehicle stopEngine(){
        return new TransportTruck<T>(getPosition(), getDirection(), 0, false, storage, ramp);
    }

    @Override
    public IRampVehicle lower(double amount) {
        return this.lower(amount);
    }

    @Override
    public IRampVehicle raise(double amount) {
        return this.raise(amount);
    }

    */
/**
     * Returns true if the ramp is fully raised, false otherwise.
     * @return true if the ramp is fully raised, false otherwise.
     *//*

    public boolean isFullyRaised() {
        return ramp.isFullyRaised();
    }

    */
/**
     * Returns true if the ramp is fully lowered, false otherwise.
     * @return true if the ramp is fully lowered, false otherwise.
     *//*

    public boolean isFullyLowered() {
        return ramp.isFullyLowered();
    }

    @Override
    public IRampVehicle move(){
        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
        Vector2D newPos = getPosition().plus(step);
        storage.getCarried(getPosition(), getDirection());
        return new TransportTruck<T>(newPos, getDirection(), getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

//    @Override
//    public void getCarried(Vector2D position, Vector2D direction) {
//
//        // this.setPosition(position);
//        // this.setDirection(direction);
//        storage.getCarried(position, direction);
//    }

    @Override
    public IRampVehicle turnLeft(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(Math.PI / 2);
        return new TransportTruck<T>(getPosition(), dir, getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle turnRight(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI / 2);
        return new TransportTruck<T>(getPosition(), dir, getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle gas(double amount) {
        return new TransportTruck<T>(getPosition(), getDirection(),
                getIncrementedSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
                isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle brake(double amount) {
        return new TransportTruck<T>(getPosition(), getDirection(),
                getDecrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
                isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle turnAround(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI);
        return new TransportTruck<T>(getPosition(), dir, getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

    @Override
    public <T extends ITransportable> T follow(ITransporter<T> transporter) {
        storage.follow(transporter);
        // uppdatera storage med ny pos.

        return null;
    }
}
*/
