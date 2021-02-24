package Model;

/**
 * A movable ferry able to transport things
 * @param <T> the things to transport
 */
public class Ferry<T extends Transportable> extends Vehicle implements Transporter<T> {
    /**
     * storage component
     */
    private final FIFO<T> storage;

    /**
     * Model.Ramp component
     */
    private final Ramp ramp;

    /**
     * Creates a default Model.Ferry (testing)
     */
    public Ferry(){
        super(1000, 5, 15);
        storage = new FIFO<T>(10, 1, 1, 2, getPosition(), getDirection(), getLength());
        ramp = new Ramp(70, 1);
    }

    /**
     * Creates a Model.Ferry based on some storage
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
     * Remove something from the Model.Ferry's storage component, how it's removed
     */
    public T remove() {
    if (!ramp.isFullyLowered()) {
        throw new IllegalStateException("Model.Ramp not fully lowered");
    }
    return storage.remove();
    }

    /**
     * Gets the size of the Model.Ferry's storage
     * @return the size
     */
    @Override
    public int getSize() {
        return storage.getSize();
    }

    // ------ MOVABLE --------


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
     * Determines the speed factor of the Model.Ferry.
     * @return the speed factor of the Model.Ferry
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
    * Disables the Model.Ferry to be moved
    */
    @Override
    public void startEngine() {
        if(ramp.isFullyRaised())
            super.startEngine();
    }

    @Override
    public void move() {
        super.move();
        storage.relocate(getPosition(), getDirection());
    }

}

