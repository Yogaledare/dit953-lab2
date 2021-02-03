import java.awt.*;

public class Scania implements Movable, Storable, Positionable, AuxPlatform {

    private double platformAngle;

    private Car car;

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
    public Scania(double enginePower, String modelName, Color color, int nrDoors, double width, double length) {
        car = new Car(enginePower, modelName, color, nrDoors, width, length);
        platformAngle = 0;
    }

    public Scania(Car car) {
        this.car = car;
        platformAngle = 0;
    }



    @Override
    public double findSpeedFactor() {
        return car.getEnginePower() * 0.01;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void gas(double amount, double speedFactor) {

    }

    @Override
    public void brake(double amount, double speedFactor) {

    }

    @Override
    public boolean raise() {
        setPlatformAngle(70);
        return (getPlatformAngle() == 70);
    }

    @Override
    public boolean lower() {

        return false;
    }

    @Override
    public void startEngine() {
        if (platformAngle == 0) {
            car.startEngine();
        }
    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = platformAngle;
    }

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
