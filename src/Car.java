import java.awt.*;

public class Car implements Transportable {
    /**
     * Car model
     */
    private final String modelName;
    /**
     * Color of car
     */
    private Color color;

    /**
     * Number of doors
     */

    private final int nrDoors;

    private final Vehicle vehicle;

//    private final double width;
//
//    private final double length;


    public Car(double enginePower, double width, double length, String modelName, Color color, int nrDoors){
        this.vehicle = new Vehicle(enginePower, width, length);
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        vehicle.setPosition(new Vector2D(0, 0));
    }

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


    public double getEnginePower() {
        return vehicle.getEnginePower();
    }


    /**
     * Returns the width of the car.
     * @return the width of the car
     */
    @Override
    public double getWidth() {
        return vehicle.getWidth();
    }

    /**
     * Returns the length of the car.
     * @return the length of the car
     */
    @Override
    public double getLength() {
        return vehicle.getLength();
    }

    /**
     * Sets the position of the car.
     */
    @Override
    public void setPosition(Vector2D position) {
        vehicle.setPosition(position);
    }

    /**
     * Returns the position of the car.
     * @return the position of the car
     */
    @Override
    public Vector2D getPosition() {
        return vehicle.getPosition();
    }

    public Vector2D getDirection(){ return vehicle.getDirection(); }



    public void move() {
        vehicle.move();
    }


    public void turnLeft() {
        vehicle.turnLeft();
    }


    public void turnRight() {
        vehicle.turnRight();
    }

//    @Override
//    public double findSpeedFactor() {
//        return 0;
//    }

    public void gas(double amount, double speedFactor) {
        vehicle.gas(amount, speedFactor);
    }


    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, speedFactor);
    }


    public boolean isMoving() {
        return vehicle.isMoving();
    }


    public void startEngine() {
        vehicle.startEngine();
    }

    public void stopEngine() {
        vehicle.stopEngine();
    }

    public double getCurrentSpeed(){
        return vehicle.getCurrentSpeed();
    }
}
