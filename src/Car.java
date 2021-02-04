import java.awt.*;

/**
 * The car component representing car features
 */
public class Car {
    /**
     * Car model
     */
    private final String modelName;

    /**
     * Color of car
     */
    private Color color;

    /**
     * Number of doors the car has
     */
    private final int nrDoors;

    /**
     * The underlying vehicle object
     */
    private final Vehicle vehicle;

//    private final double width;
//
//    private final double length;


    public Car(double enginePower, double width, double length, String modelName, Color color, int nrDoors){
        this.vehicle = new Vehicle(enginePower, width, length);
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
//        vehicle.setPosition(new Vector2D(0, 0));
    }
    /**
     * Creates a representation of a car
     * @param enginePower How powerful the car is
     * @param width How wide the car is
     * @param length How long the car is
     * @param modelName The name of the car
     * @param color The color of the car
     * @param nrDoors How many doors the car has
     * @param pos Where to place the car
     */
    public Car(double enginePower, double width, double length, String modelName, Color color, int nrDoors, Vector2D pos){
        this(enginePower, width, length, modelName, color, nrDoors);
        vehicle.setPosition(pos);
    }

    /**
     * Returns the number of doors of the car.
     * @return the number of doors of the car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the color of the car.
     * @return the color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of car.
     * @param clr the new color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Returns the modelName of the car.
     * @return the modelName of the car
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Returns how powerful the car is
     * @return how powerful the car is
     */
    public double getEnginePower() {
        return vehicle.getEnginePower();
    }

    /**
     * Returns the width of the car.
     * @return the width of the car
     */
//    @Override
    public double getWidth() {
        return vehicle.getWidth();
    }

    /**
     * Returns the length of the car.
     * @return the length of the car
     */

    public double getLength() {
        return vehicle.getLength();
    }

    /**
     * Sets the position of the car.
     */
    public void setPosition(Vector2D position) {
        vehicle.setPosition(position);
    }

    /**
     * Sets the direction of the car
     * @param direction direction to be set
     */
    public void setDirection(Vector2D direction) {
        vehicle.setDirection(direction);
    }

    /**
     * Returns the position of the car.
     * @return the position of the car
     */
    public Vector2D getPosition() {
        return vehicle.getPosition();
    }

    /**
     * Returns the direction of the car.
     * @return the direction of the car
     */
    public Vector2D getDirection(){ return vehicle.getDirection(); }

    /**
     * Move the car based on its speed
     */
    public void move() {
        vehicle.move();
    }

    /**
     * Turn the car left
     */
    public void turnLeft() {
        vehicle.turnLeft();
    }

    /**
     * Turn the car right
     */
    public void turnRight() {
        vehicle.turnRight();
    }

    /**
     * Returns number of doors on the car
     * @return number of doors on the car
     */
    public int getNoOfDoors() { return this.nrDoors; }

    public void gas(double amount, double speedFactor) {
        vehicle.gas(amount, speedFactor);
    }

    /**
     * Reduces the speed of the car
     * @param amount how much to reduce the speed
     * @param speedFactor speed modifier
     */
    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, speedFactor);
    }

    /**
     * Returns true if the car is moving
     * @return true if car is moving
     */
    public boolean isMoving() {
        return vehicle.isMoving();
    }

    /**
     * Enables the car to be moved
     */
    public void startEngine() {
        vehicle.startEngine();
    }

    /**
     * Disables the car to be moved
     */
    public void stopEngine() {
        vehicle.stopEngine();
    }

    /**
     * Returns how fast the car is moving
     * @return how fast the car is moving
     */
    public double getCurrentSpeed(){
        return vehicle.getCurrentSpeed();
    }
}
