public class Ferry<T extends Transportable> implements Movable/*, IStorageUnit<T>*/ {

    private final FIFO<T> storage;
    private final Vehicle vehicle;
    private final Ramp ramp;

    public Ferry(){
        vehicle = new Vehicle(1000, 5, 15);
        storage = new FIFO<T>(10, 1, 1, 2, vehicle.getPosition(), vehicle.getDirection(), vehicle.getLength());
        ramp = new Ramp(70, 1);
    }

    public Ferry(FIFO<T> storageUnit) {
        vehicle = new Vehicle(1000, 5, 15);
        this.storage = storageUnit;
        ramp = new Ramp(70, 1);
    }

    // ------ STORABLE --------
//    @Override
    public void store(T car) {
        if (vehicle.getPosition().distanceTo(car.getPosition()) < 2 && ramp.isFullyLowered()) {
            storage.store(car);
        }
    }

//    @Override
    public T remove() {
    if (!ramp.isFullyLowered()) {
        throw new IllegalStateException("Ramp not fully lowered");
    }
    return storage.remove();
    }

    @Override
    public int getSize() {
        return storage.getSize();
    }

    // ------ MOVABLE --------
//    @Override
    @Override
    public void move() {
        if (ramp.isFullyRaised()) {
            vehicle.move();
            storage.relocate(vehicle.getPosition(), vehicle.getDirection());
        }
    }

    /**
     * Turns the vehicle 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        if(ramp.isFullyRaised())
            vehicle.turnLeft();
    }

    /**
     * Turns the vehicle 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        if(ramp.isFullyRaised())
            vehicle.turnRight();
    }

    @Override
    public void gas(double amount) {
        vehicle.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount) {
        vehicle.brake(amount, findSpeedFactor());
    }

    @Override
    public boolean isMoving() {
        return false;
    }

    @Override
    public void startEngine() {
        vehicle.startEngine();
    }

    @Override
    public void stopEngine() {
        vehicle.stopEngine();
    }

    /**
     * Determines the speed factor of the vehicle.
     * @return the speed factor of the vehicle
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