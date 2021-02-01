import java.awt.*;

public class CarTransportTruck extends Car implements Movable, IStorageUnit{

    private LIFOStorageUnit LIFOStorageUnit;

    public CarTransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             int capacity, double maxWidth, double maxHeight) {
        super(modelName, color, enginePower, nrDoors);
        this.LIFOStorageUnit = new LIFOStorageUnit(capacity, maxWidth, maxHeight);
    }

    @Override
    public double findSpeedFactor() {
        return 0;
    }

    public void store(Storable car) {
        LIFOStorageUnit.store(car);
    }

    public Storable remove() {
        return LIFOStorageUnit.remove();
    }


    public double getMaxWidth() {
        return LIFOStorageUnit.getMaxWidth();
    }

    public double getMaxHeight() {
        return LIFOStorageUnit.getMaxHeight();
    }

}
