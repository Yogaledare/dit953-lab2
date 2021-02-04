import java.awt.*;

public class Car implements Movable, Transportable {
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


    public Car(double enginePower, double width, double length, String modelName, Color color, int nrDoors/*, double width, double length*/){
        this.vehicle = new Vehicle(enginePower, width, length);
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
//        this.width = width;
//        this.length = length;
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

    @Override
    public void move() {
        vehicle.move();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

//    @Override
//    public double findSpeedFactor() {
//        return 0;
//    }

    @Override
    public void gas(double amount, double speedFactor) {
        vehicle.gas(amount, speedFactor);
    }

    @Override
    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, speedFactor);
    }

    @Override
    public boolean isMoving() {
        return vehicle.isMoving();
    }
}
