import java.awt.*;

public class TransportTruck<T extends Vehicle> extends Vehicle implements Movable, IStorageUnit<T> {

    private final LIFOStorageUnit<T> LIFOStorageUnit;
    private final double truckLength;

    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             double truckLength, LIFOStorageUnit<T> LIFOStorageUnit) {
        super(modelName, color, enginePower, nrDoors);
        this.truckLength = truckLength;
        this.LIFOStorageUnit = LIFOStorageUnit;
    }

    @Override
    public double findSpeedFactor() {
        return 0;
    }

    // For an object to be a specific _Car_ storage truck, that has to be declared when creating the object.
    public void store(T car) {
        LIFOStorageUnit.store(car);
        car.setPosition(this.getPosition());

    }

    public T remove() {
        T car = LIFOStorageUnit.remove();
        Vector2D offset = this.getDirection().multiplyByScalar(-truckLength / 2.1);
        Vector2D unloadedPosition = this.getPosition().plus(offset);
        car.setPosition(unloadedPosition);
        return car;
    }

    public void move() {
        super.move();
        for(T car : LIFOStorageUnit.getStorage()) {
            car.setPosition(this.getPosition());
        }
    }


}



/*    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             int capacity, double maxWidth, double maxHeight) {
        super(modelName, color, enginePower, nrDoors);
        this.LIFOStorageUnit = new LIFOStorageUnit<T>(capacity, maxWidth, maxHeight);
    }*/

