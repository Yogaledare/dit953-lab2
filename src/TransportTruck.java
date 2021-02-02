import java.awt.*;

public class TransportTruck<T extends Storable> extends Vehicle implements Movable, IStorageUnit<T> {

    private final LIFO<T> storage;
    private final double truckLength;

    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             double truckLength, LIFO<T> storage) {
        super(modelName, color, enginePower, nrDoors);
        this.truckLength = truckLength;
        this.storage = storage;
    }

    @Override
    public double findSpeedFactor() {
        return 0;
    }

    // For an object to be a specific _Car_ storage truck, that has to be declared when creating the object.
    public void store(T car) {
        storage.add(car);
        car.setPosition(this.getPosition());
    }

    public T remove() {
        T car = storage.remove();
        Vector2D offset = this.getDirection().multiplyByScalar(-truckLength / 2.1);
        Vector2D unloadedPosition = this.getPosition().plus(offset);
        car.setPosition(unloadedPosition);
        return car;
    }

    public void move() {
        super.move();
        for(T car : storage.getStorage()) {
            car.setPosition(this.getPosition());
        }
    }


}



/*    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             int capacity, double maxWidth, double maxHeight) {
        super(modelName, color, enginePower, nrDoors);
        this.LIFOStorageUnit = new LIFOStorageUnit<T>(capacity, maxWidth, maxHeight);
    }*/

