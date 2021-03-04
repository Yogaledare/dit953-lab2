package Model;

/**
 * A movable ferry able to transport things
 * @param <T> the things to transport
 */
public class Ferry<T extends ITransportable> extends Vehicle implements ITransporter<T>, IRampVehicle {

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
    public Ferry(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn) {
        super(position, direction, currentSpeed, engineOn, 1000, 8, 15);
        storage = new FIFO<T>(10, 1, 1, 2, getPosition(), getDirection(), getLength());
        ramp = new Ramp(70, 1);

    }

    /**
     * Creates a Ferry based on some storage
     * @param storageUnit already existing storage
     */
    public Ferry(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, FIFO<T> storageUnit, Ramp ramp) {
        super(position, direction, currentSpeed, engineOn, 1000, 5, 15);
        this.storage = storageUnit;
        this.ramp = ramp;
    }

    public Ferry(Ferry<T> ferry){
        super(ferry.getPosition(), ferry.getDirection(), ferry.getCurrentSpeed(), ferry.isEngineOn(), 1000, 8, 15);
        this.storage = ferry.storage;
        this.ramp = ferry.ramp;
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
        throw new IllegalStateException("Model.Model.Ramp not fully lowered");
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
     * Determines the speed factor of the Model.Model.Ferry.
     * @return the speed factor of the Model.Model.Ferry
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
    * Disables the Ferry to be moved
    */
    @Override
    public IRampVehicle startEngine() {
        if(ramp.isFullyRaised()) {
            double speed = 0;
            if(!isEngineOn())
                speed = 0.1;
            return new Ferry<T>(getPosition(), getDirection(), speed, true, storage, ramp);
        }
        return new Ferry<T>(this);
    }

    @Override
    public IRampVehicle stopEngine(){
        return new Ferry<T>(getPosition(), getDirection(), 0, false, storage, ramp);
    }

    @Override
    public void lower(double amount) {

    }

    @Override
    public void raise(double amount) {

    }

    @Override
    public boolean isFullyRaised() {
        return false;
    }

    /**
     * Move the ferry
     */
    @Override
    public IRampVehicle move(){
        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
        Vector2D newPos = getPosition().plus(step);
        storage.getCarried(getPosition(), getDirection());
        return new Ferry<T>(newPos, getDirection(), getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle turnLeft(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(Math.PI / 2);
        return new Ferry<T>(getPosition(), dir, getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle turnRight(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI / 2);
        return new Ferry<T>(getPosition(), dir, getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle gas(double amount) {
        return new Ferry<T>(getPosition(), getDirection(),
                getIncrementedSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
                isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle brake(double amount) {
        return new Ferry<T>(getPosition(), getDirection(),
                getDecrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
                isEngineOn(), storage, ramp);
    }

    @Override
    public IRampVehicle turnAround(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI);
        return new Ferry<T>(getPosition(), dir, getCurrentSpeed(), isEngineOn(), storage, ramp);
    }

}

