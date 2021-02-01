import java.awt.*;

public class TransportTruck<T extends Car> extends Car implements Movable, IStorageUnit<T> {

    private final LIFOStorageUnit<T> LIFOStorageUnit;


    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             LIFOStorageUnit<T> LIFOStorageUnit) {
        super(modelName, color, enginePower, nrDoors);
        this.LIFOStorageUnit = LIFOStorageUnit;
    }

    @Override
    public double findSpeedFactor() {
        return 0;
    }

    // For an object to be a specific _Car_ storage truck, that has to be declared when creating the object.
    public void store(T item) {
        LIFOStorageUnit.store(item);
    }

    public T remove() {
        return LIFOStorageUnit.remove();
    }


    // public double getMaxWidth() {
    //    return LIFOStorageUnit.getMaxWidth();
    // }

    // public double getMaxLength() {
    //    return LIFOStorageUnit.getMaxLength();
    // }

}



/*    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             int capacity, double maxWidth, double maxHeight) {
        super(modelName, color, enginePower, nrDoors);
        this.LIFOStorageUnit = new LIFOStorageUnit<T>(capacity, maxWidth, maxHeight);
    }*/

