import java.awt.*;

public class TransportTruck<T extends Transportable> implements Movable, Transporter<T> /*, Transportable, IStorageUnit<T>, AuxPlatform */ {
/*
    Biltransportens ramp har endast två lägen, uppe eller nere.
    Rampen kan endast vara nere om biltransporten står stilla.
    Bilar kan endast lastas om rampen är nere, och de befinner sig rimligt nära biltransporten (gör ett eget antagande, de exakta detaljerna är inte viktiga).
    Bilar kan endast lossas om rampen är nere.
     De bör då hamna rimligt nära biltransporten.

    Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som lastades måste vara först att lossas (first-in-last-out).
    Biltransporten ska inte kunna lasta på sig själv.
    Under det att en bil är lastad på biltransporten ska dess position i världen alltid vara densamma som biltransportens position.

    Viktiga saker att ha i åtanke under den här uppgiften:

    Undvik kodduplicering för funktionalitet som är gemensam för flera olika klasser, e.g. lastbil och biltransport.
    Fundera över behovet av polymorfism för olika ändamål, och hur det påverkar framtida extensibilitet.
    Fundera över hur ni bäst håller reda på de bilar som lastats - vilken sorts datastruktur är bäst för ändamålet?

    Kom ihåg att skriva Javadoc-dokumentation, och JUnit-tester för relevanta aspekter av er kod.
    */
//    private final double cabinLength = 1.5;
//    private Vector2D position;

    private final LIFO<T> storage;

    private final Ramp ramp;

    private final Car car;

    public TransportTruck(double enginePower, double width, double length, int capacity, double maxW, double maxL) {
        car = new Car(enginePower, width, length, "Transport Truck", Color.red, 2);
        storage = new LIFO<>(capacity, maxW, maxL, 2, car.getPosition(), car.getDirection(), car.getLength());
        ramp = new Ramp(70, 1);
    }

    public TransportTruck(Car car, int capacity, double maxW, double maxL) {
        this.car = car;
        storage = new LIFO<>(capacity, maxW, maxL, 2, car.getPosition(), car.getDirection(), car.getLength());
        ramp = new Ramp(70, 1);
    }

    // For an object to be a specific _Car_ storage truck, that has to be declared when creating the object.
    public void store(T item) {
        if (ramp.isFullyLowered()) {
            storage.store(item);
        }
    }

    /*vehicle.getPosition().distanceTo(car.getPosition()) < 2 && */

    public T remove() {
        if (!ramp.isFullyLowered()) {
            throw new IllegalStateException("Ramp not fully lowered");
        }
        return storage.remove();
//        Vector2D offset = vehicle.getDirection().multiplyByScalar(vehicle.getLength() / 2 + storage.getPickUpRange());
//        return storage.remove(offset);
    }

    @Override
    public int getSize() {
        return storage.getSize();
    }

    @Override
    public void move() {
        if (ramp.isFullyRaised()) {
            car.move();
            storage.relocate(car.getPosition(), car.getDirection());
        }
    }

    @Override
    public void turnLeft() {
        if (ramp.isFullyRaised())
            car.turnLeft();
    }

    @Override
    public void turnRight() {
        if (ramp.isFullyRaised())
            car.turnRight();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount) {
        car.brake(amount, findSpeedFactor());
    }

    @Override
    public boolean isMoving() {
        return car.getCurrentSpeed() > 0;
    }

    @Override
    public void startEngine() {
        if (ramp.isFullyRaised()) {
            car.startEngine();
        }
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    public double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
    }

    /**
     * Raise loading platform.
     * returns true if platform is at load position.
     */
    public boolean raiseRamp() {
        if (car.getCurrentSpeed() == 0) {
            ramp.raise();
        }
        return ramp.isFullyRaised();
    }

    /**
     * Lower loading platform to ground.
     * It's is only possible to lower when engine is off.
     * return true when platform is a 0 degree sensor.
     */
    public boolean lowerRamp() {
        if (car.getCurrentSpeed() == 0) {
            ramp.lower();
        }
        return ramp.isFullyLowered();
    }

//    public int getStorageCount() {
//        return storage.getSize();
//    }

//    @Override
//    public Vector2D getPosition() {
//        return position;
//    }

//    @Override
//    public double getWidth() {
//        return vehicle.getWidth();
//    }

//    @Override
//    public double getLength() {
//        return vehicle.getLength();
//    }




}

/*    @Override
    public void setPosition(Vector2D vector2D) {
        position = vector2D;
    }*/

//    @Override
//    public void moveCargo(Vector2D newPosition) {
//
//    }

/*    public T remove() {
        if (ramp.isFullyLowered()) {

            T car = storage.remove();

            Vector2D offset = vehicle.getDirection().multiplyByScalar(-truckLength / 2.1);
            Vector2D unloadedPosition = this.getPosition().plus(offset);
            car.setPosition(unloadedPosition);
            return car;
        } else {
            // fail to unload, due to ramp is up.
            return null;
        }
    }*/

//            for (T stored : storage.getStorage()) {
//                stored.setPosition(this.getPosition());
//            }



//            car.setPosition(this.getPosition());
//            storage.add(car);

//    @Override