/**
 * @author      Niklas  Axelsson < name @ student.gu.se>
 * @author      Carl    Stewart < name @ student.gu.se>
 * @author      Marcus  Uppström < gusuppma@student.gu.se>
 * @version     0.1                 (current version number of program)
 */

import java.awt.*;

public abstract class Car implements Movable {

    /**
     * Car model.
     */
    private final String modelName;

    /**
     * Color of car.
     */
    private Color color;

    /**
     * Current speed valid interval from 0 to Engine power.
     */
    private double currentSpeed;

    /**
     * Engine power
     */
    private final double enginePower;

    /**
     * Number of doors
     */
    private final int nrDoors;


    /**
     * Position for the car.
     */
    private Vector2D position;

    /**
     * Direction / orientation for which the car is heading.
     */
    private Vector2D direction;


    /**
     * Constructs a Car object with the specified modelYear, color, enginePower and nrDoors.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     * @param modelName the model name of the car
     * @param color the color of the car
     * @param enginePower the engine power of the car, relates to max speed
     * @param nrDoors the number of doors of the car
     */
    public Car(String modelName, Color color, double enginePower, int nrDoors) {
        this.modelName = modelName;
        this.color = color;
        this.enginePower = enginePower;
        this.nrDoors = nrDoors;
        this.position = new Vector2D(0,0);
        this.direction = new Vector2D(0, 1);
        stopEngine();
    }

    /**
     * Returns the number of doors of the car.
     * @return the number of doors of the car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the enginePower of the car.
     * @return the enginePower of the car
     */
    public double getEnginePower() { return enginePower; }


    /**
     * Returns the current speed of the car. The speed has a value between 0 and the enginePower of the car.
     * @return the current speed of the car.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the color of the car.
     * @return the color of the car.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns the modelName of the car.
     * @return the modelName of the car
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets the color of car.
     * @param clr the new color of the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the car by setting currentSpeed to 0.1.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the car by setting currentSpoeed to 0.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }


    /**
     * Return speed factor.
     * @return Returns the speed factor.
     */
    public abstract double findSpeedFactor();

    /**
     * Increase speed
     * @param amount how much the speed should increase for every move.
     */
    private void incrementSpeed(double amount) {
        currentSpeed = (Math.min(getCurrentSpeed() + findSpeedFactor() * amount, enginePower));
    }

    /**
     * Decrease speed
     * @param amount how much the speed should decrease for every move.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = (Math.max(getCurrentSpeed() - findSpeedFactor() * amount, 0));
    }

    /**
     * Gas can only be the same or increase
     * @param amount how much the gas is pressed
     */
    public void gas(double amount){
        incrementSpeed(clamp(amount, 0, 1));
    }

    /**
     * Release the gas
     * @param amount decrease the gas.
     */
    public void brake(double amount){
        decrementSpeed(clamp(amount, 0.1, 1)); // min set to 0.1 since 0.0 == engineStop ?!
    }

    /**
     * Move car in its current direction an amount proportional to its speed.
     */
    public void move() {
        Vector2D step = direction.multiplyByScalar(currentSpeed);
        position = position.plus(step);
    }

    /**
     * Turn car 90 degrees to left.
     */
    public void turnLeft() {
        direction = direction.rotateCC(Math.PI / 2);
    }

    /**
     * Turn car 90 degrees to right.
     */
    public void turnRight() {
        direction = direction.rotateCC(-Math.PI / 2);
    }

    // Todo: javadoc
    private double clamp(double d, double min, double max){
        d = Math.max(d, min);
        return Math.min(d, max);
    }

    // Todo: javadoc
    public Vector2D getPosition() {
        return position;
    }

    // Todo: javadoc
    public Vector2D getDirection() {
        return direction;
    }

}


/*
 *//* *
 * set the car model, is it really allowed to change this ?
 * @param modelName change model name to something new.
 *//*
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    */



/*

 */
/* *
 * Set number of doors the car have.
 * @param nrDoors number of passenger doors, including driver but  excluding bonnet.
 *//*

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }
*/



/* *
 * Engine power in bhp?
 * @param enginePower valid interval 0-1 ?
 *//*

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }
*/

