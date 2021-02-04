import java.awt.*;

/**
 * A movable truck with a movable ramp
 */
public class Scania implements Movable, Transportable {

    /**
     * Car component.
     */
    private final Car car;
    private final Ramp ramp;

    /**
     * Constructs a Scania truck object with the specified modelName, color, enginePower, nrDoors, width and length.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     *
     * @param enginePower the power of the engine
     * @param modelName   the model name of the car
     * @param color       the color of the car
     * @param nrDoors     the number of doors of the car
     * @param width       the width of the car
     * @param length      the length of the car
     */
    public Scania(double enginePower, double width, double length, String modelName, Color color, int nrDoors) {
        car = new Car(enginePower, width, length, modelName, color, nrDoors, new Vector2D(0, 0));
        ramp = new Ramp(70, 1);
    }

    public Scania(Car car) {
        this.car = car;
        ramp = new Ramp(70, 1);
    }

//    public Scania(){
//        car = new Car(10, 2, 3, "Scania", Color.blue, 2, 3, 5);
//        ramp = new Ramp(70, 1);
//    }

    public double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {
        if(ramp.isFullyRaised())
            car.turnLeft();
    }

    @Override
    public void turnRight() {
        if(ramp.isFullyRaised())
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
        return car.isMoving();
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    /**
     * Sets the direction of the truck.
     * @param direction the new direction.
     */
    @Override
    public void setPosition(Vector2D position) {
        car.setPosition(position);
    }

    @Override
    public Vector2D getPosition() {
        return car.getPosition();
    }

    @Override
    public double getWidth() {
        return car.getWidth();
    }

    @Override
    public double getLength() {
        return car.getLength();
    }
}
