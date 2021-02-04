public class Ferry<T extends Transportable> implements Movable/*, IStorageUnit<T>*/ {

    private final FIFO<T> storage;
    /**
     * Vehicle component
     */
    private final Vehicle vehicle;
    /**
     * Ramp component
     */
    private final Ramp ramp;

    /**
     * Creates a default Ferry (testing)
     */
    public Ferry(){
        vehicle = new Vehicle(1000, 5, 15);
        storage = new FIFO<T>(10, 1, 1, 2, vehicle.getPosition(), vehicle.getDirection(), vehicle.getLength());
        ramp = new Ramp(70, 1);
    }

    /**
     * Creates a Ferry based on some storage
     * @param storageUnit already existing storage
     */
    public Ferry(FIFO<T> storageUnit) {
        vehicle = new Vehicle(1000, 5, 15);
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
     * Moves the Ferry
     */
    @Override
    public void move() {
        if (ramp.isFullyRaised()) {
            vehicle.move();
            storage.relocate(vehicle.getPosition(), vehicle.getDirection());
        }
    }

    /**
     * Turns the Ferry 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        if(ramp.isFullyRaised())
            vehicle.turnLeft();
    }

    /**
     * Turns the Ferry 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        if(ramp.isFullyRaised())
            vehicle.turnRight();
    }

    /**
     * increases the speed of the Ferry
     * @param amount how much to increase the speed
     */
    @Override
    public void gas(double amount) {
        vehicle.gas(amount, findSpeedFactor());
    }

    /**
     * Reduces the speed of the Ferry
     * @param amount how much to reduce the speed
     */
    @Override
    public void brake(double amount) {
        vehicle.brake(amount, findSpeedFactor());
    }

    /**
     * Returns true if the Ferry is moving
     * @return true if Ferry is moving
     */
    @Override
    public boolean isMoving() {
        return false;
    }

    /**
     * Enables the Ferry to be moved
     */
    @Override
    public void startEngine() {
        vehicle.startEngine();
    }

    /**
     * Disables the Ferry to be moved
     */
    @Override
    public void stopEngine() {
        vehicle.stopEngine();
    }

    /**
     * Determines the speed factor of the Ferry.
     * @return the speed factor of the Ferry
     */
    public double findSpeedFactor() {
        return vehicle.getEnginePower() * 0.01;
    }

}


/*
    Skapa en representation av en bilfärja - dvs en färja på vilken det går att lasta bilar.

    Notera att bilfärjan inte är en bil (doh), men att många av de metoder vi hittills använt för olika sorters bilar bör gå att applicera även på färjan.
    Hur åstadkommer ni bäst detta?
    - implements Movable

    På bilfärjan gäller samma regler som för biltransporten,
    med undantaget att bilar lossas i samma ordning som de lastades,
    dvs den första bilen som lastades måste vara först att lossas (first-in-first-out).



Viktiga saker att ha i åtanke under den här uppgiften:

    Undvik kodduplicering för funktionalitet som är gemensam för e.g. bilfärjan och biltransporten.
    Fundera över behovet av polymorfism - nuvarande och ev. framtida.


 */