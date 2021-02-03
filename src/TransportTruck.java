import java.awt.*;

public class TransportTruck<T extends Storable> extends Vehicle implements Movable, IStorageUnit<T>, AuxRamp {

    private final LIFO<T> storage;
    private final double truckLength;
    private double rampAngle = 45;
    private final double RAMPSPEED = 1;

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
        // TODO: It should only be possible to store a car when ramp is down at 0 degree
        if (rampAngle == 0) {
            storage.add(car);
            car.setPosition(this.getPosition());
        }
    }

    public T remove() {
        // TODO: It should only be possible to store a car when ramp is down at 0 degree
        if (rampAngle == 0) {
            T car = storage.remove();
            Vector2D offset = this.getDirection().multiplyByScalar(-truckLength / 2.1);
            Vector2D unloadedPosition = this.getPosition().plus(offset);
            car.setPosition(unloadedPosition);
            return car;
        } else {
            // fail to unload, due to ramp is up.
            return null;
        }
    }

    public void move() {
        // TODO: do not drive when ramp is down.
        // TODO: This is ugly, closed == 70 . use enum [OPEN, INPROGRESS, CLOSED]?
        if (getRampAngle() == 70) {
            super.move();
            for (T car : storage.getStorage()) {
                car.setPosition(this.getPosition());
            }
        }
    }

    public double getRampAngle() {
        return rampAngle;
    }

    /**
     * Raise loading platform.
     * returns true if platform is at load position.
     */
    public boolean raiseRamp() {
        if (getCurrentSpeed() == 0) {
            while (rampAngle < 70) {
                rampAngle = Vector2D.clamp(rampAngle += RAMPSPEED, 0, 70);
            }
        }
        return (getRampAngle() == 70);
    }


    /**
     * Lower loading platform to ground.
     * It's is only possible to lower when engine is off.
     * return true when platform is a 0 degree sensor.
     */
    public boolean lowerRamp() {
        if (getCurrentSpeed() == 0) {
            while (rampAngle > 0) {
                rampAngle = Vector2D.clamp(rampAngle -= RAMPSPEED, 0, 70);
            }
        }
        return (getRampAngle() == 0);
    }

    public int getStorageCount() {
        return storage.getSize();
    }
}



/*    public TransportTruck(String modelName, Color color, double enginePower, int nrDoors,
                             int capacity, double maxWidth, double maxHeight) {
        super(modelName, color, enginePower, nrDoors);
        this.LIFOStorageUnit = new LIFOStorageUnit<T>(capacity, maxWidth, maxHeight);
    }*/

