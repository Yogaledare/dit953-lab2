/**
 * A movable ferry able to transport things
 * @param <T> the things to transport
 */
public class Ferry<T extends Transportable> extends Vehicle implements Movable, Transporter<T> {
    /**
     * storage component
     */
    private final FIFO<T> storage;

    /**
     * Ramp component
     */
    private final Ramp ramp;

    /**
     * Creates a default Ferry (testing)
     */
    public Ferry(){
        super(1000, 5, 15);
        storage = new FIFO<T>(10, 1, 1, 2, getPosition(), getDirection(), getLength());
        ramp = new Ramp(70, 1);
    }

    /**
     * Creates a Ferry based on some storage
     * @param storageUnit already existing storage
     */
    public Ferry(FIFO<T> storageUnit) {
        super(1000, 5, 15);
        this.storage = storageUnit;
        ramp = new Ramp(70, 1);
    }

    // ------ STORABLE --------

    /**
     * Store something in the Ferrys storage component
     * @param item thing to store
     */
    public void store(T item) {
        if (ramp.isFullyLowered()) {
            storage.store(item);
        } else {
            System.err.println("Check if ramp is lowered!");
        }
    }

    /**
     * Remove something from the Ferry's storage component, how it's removed
     */
    public T remove() {
    if (!ramp.isFullyLowered()) {
        throw new IllegalStateException("Ramp not fully lowered");
    }
    return storage.remove();
    }

    /**
     * Gets the size of the Ferry's storage
     * @return the size
     */
    @Override
    public int getSize() {
        return storage.getSize();
    }

    // ------ MOVABLE --------

    /**
     * increases the speed of the Ferry
     * @param amount how much to increase the speed
     */
    @Override
    public void gas(double amount) {
        gas(amount, findSpeedFactor());
    }

    /**
     * Reduces the speed of the Ferry
     * @param amount how much to reduce the speed
     */
    @Override
    public void brake(double amount) {
        brake(amount, findSpeedFactor());
    }

    /**
     * Determines the speed factor of the Ferry.
     * @return the speed factor of the Ferry
     */
    private double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

}


/*

    */
/**
     * Returns true if the Ferry is moving
     * @return true if Ferry is moving
     *//*

    @Override
    public boolean isMoving() {
        return false;
    }

    */
/**
     * Enables the Ferry to be moved
     *//*

    @Override
    public void startEngine() {
        vehicle.startEngine();
    }

    */
/**
     * Disables the Ferry to be moved
     *//*

    @Override
    public void stopEngine() {
        vehicle.stopEngine();
    }
*/


/*


    */
/**
     * Moves the Ferry
     *//*

    @Override
    public void move() {
        if (ramp.isFullyRaised()) {
            vehicle.move();
            storage.relocate(vehicle.getPosition(), vehicle.getDirection());
        }
    }

    */
/**
     * Turns the Ferry 90 degrees to the left.
     *//*

    @Override
    public void turnLeft() {
        if(ramp.isFullyRaised())
            vehicle.turnLeft();
    }

    */
/**
     * Turns the Ferry 90 degrees to the right.
     *//*

    @Override
    public void turnRight() {
        if(ramp.isFullyRaised())
            vehicle.turnRight();
    }
*/


/*

    */
/**
     * Vehicle component
     *//*

    private final Vehicle vehicle;

    */
