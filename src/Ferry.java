import java.awt.*;

public class Ferry<T extends Storable & Positionable> implements Movable, IStorageUnit<T> {

    private final FIFO<T> storage;
    private final Vehicle vehicle;
    private final Ramp ramp;

    public Ferry(){
        storage = new FIFO<T>(10, 1, 1);
        vehicle = new Vehicle(1000);
        ramp = new Ramp(70, 1);
    }

    public Ferry(FIFO<T> storageUnit) {
        this.storage = storageUnit;
        vehicle = new Vehicle(1000);
        ramp = new Ramp(70, 1);
    }

    // ------ STORABLE --------
    @Override
    public void store(T item) {
        if (vehicle.getPosition().dst(item.getPosition()) < 2 && ramp.fullyLowered()) {
            storage.add(item);
            item.setPosition(vehicle.getPosition());
        }
    }

    @Override
    public T remove() {
        if (ramp.fullyLowered()) {
            T car = storage.remove();
            Vector2D offset = vehicle.getDirection().multiplyByScalar(5);
            Vector2D unloadedPosition = vehicle.getPosition().plus(offset);
            car.setPosition(unloadedPosition);
            return car;
        } else {
            // fail to unload, due to ramp is up.
            return null;
        }
    }

    // ------ MOVABLE --------
    @Override
    public void move() {
        if (ramp.fullyRaised()) {
            vehicle.move();
            storage.follow(vehicle);
            for (T stored : storage.getStorage()) {
                stored.setPosition(vehicle.getPosition());
            }
        }
    }

    /**
     * Turns the vehicle 90 degrees to the left.
     */
    @Override
    public void turnLeft() {
        if(ramp.fullyRaised())
            vehicle.turnLeft();
    }

    /**
     * Turns the vehicle 90 degrees to the right.
     */
    @Override
    public void turnRight() {
        if(ramp.fullyRaised())
            vehicle.turnRight();
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