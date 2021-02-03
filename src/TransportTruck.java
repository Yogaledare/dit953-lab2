import java.awt.*;

public class TransportTruck<T extends Storable & Positionable> implements Movable, Positionable, IStorageUnit<T>, AuxPlatform {
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

    private final LIFO<T> storage;
    private final double truckLength;

    private final Ramp ramp;

    private final Vehicle vehicle;
    private Vector2D position;

    public TransportTruck(double truckLength, int capacity, double maxW, double maxL) {
        this.truckLength = truckLength;
        storage = new LIFO<T>(capacity, maxW, maxL);
        vehicle = new Vehicle(10000000);
        ramp = new Ramp(70, 1);
    }

    // For an object to be a specific _Car_ storage truck, that has to be declared when creating the object.
    public void store(T car) {
        if (position.dst(car.getPosition()) < 2 && ramp.fullyLowered()) {
            storage.add(car);
            car.setPosition(this.getPosition());
        }
    }

    public T remove() {
        if (ramp.fullyLowered()) {
            T car = storage.remove();
            Vector2D offset = vehicle.getDirection().multiplyByScalar(-truckLength / 2.1);
            Vector2D unloadedPosition = this.getPosition().plus(offset);
            car.setPosition(unloadedPosition);
            return car;
        } else {
            // fail to unload, due to ramp is up.
            return null;
        }
    }

    @Override
    public void move() {
        if (ramp.fullyRaised()) {
            vehicle.move();
            for (T stored : storage.getStorage()) {
                stored.setPosition(this.getPosition());
            }
        }
    }

    @Override
    public void turnLeft(){
        if(ramp.fullyRaised())
            vehicle.turnLeft();
    }

    @Override
    public void turnRight(){
        if(ramp.fullyRaised())
            vehicle.turnRight();
    }

    @Override
    public void gas(double amount, double speedFactor) {
        vehicle.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, findSpeedFactor());
    }

    public double findSpeedFactor() {
        return vehicle.getEnginePower() * 0.01;
    }

    /**
     * Raise loading platform.
     * returns true if platform is at load position.
     */
    public boolean raise() {
        if (vehicle.getCurrentSpeed() == 0) {
            ramp.raise();
        }
        return ramp.fullyRaised();
    }

    /**
     * Lower loading platform to ground.
     * It's is only possible to lower when engine is off.
     * return true when platform is a 0 degree sensor.
     */
    public boolean lower() {
        if (vehicle.getCurrentSpeed() == 0) {
            ramp.lower();
        }
        return ramp.fullyLowered();
    }

    public int getStorageCount() {
        return storage.getSize();
    }

    @Override public Vector2D getPosition(){ return position; }
    @Override public void setPosition(Vector2D vector2D){ position = vector2D; }


}