/**
 * @author      Niklas  Axelsson < name @ student.gu.se>
 * @author      Carl    Stewart < name @ student.gu.se>
 * @author      Marcus  Uppström < name @ student.gu.se>
 * @version     0.1                 (current version number of program)
 */

import java.awt.*;

public abstract class Car implements Movable {
    Car () {
        position = new Vector2D(0,0);
        direction = new Vector2D(0, 1);
    }
    /**
     * Car model.
     */
    public String modelName;

    /**
     * Color of car
     */
    public Color color;

    /**
     * Current speed valid interval from 0 to 1.0
     */
    public double currentSpeed;

    /**
     * Engine power
     */
    public double enginePower;

    /**
     * Number of doors
     */
    public int nrDoors;

    private Vector2D position;
    private Vector2D direction;


    /**
     * Numbers of doors the car have.
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Set number of doors the car have.
     * @param nrDoors number of passenger doors, including driver but  excluding bonnet.
     */
    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }


    /**
     * Returns how much power the car have.
     * @return power of the car
     */
    public double getEnginePower() { return enginePower; }

    /**
     * Engine power in bhp?
     * @param enginePower valid interval 0-1 ?
     */
    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Returns current speed
     * @return the speed from 0.1 to 1.0
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Color of the car
     * @return cars paintwork
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets color of car                                (1)
     * <p>
     * Longer description. If there were any, it would be    (2)
     * here.
     * <p>
     * And even more explanations to follow in consecutive
     * paragraphs separated by HTML paragraph breaks.
     *
     * @param  clr Description text text text.          (3)
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Start the car.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stop the car
      */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Car model
     * @return what kind of model it is.
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * set the car model, is it really allowed to change this ?
     * @param modelName change model name to something new.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Return speed factor.                           (1)
     * <p>
     * Longer description. If there were any, it would be    (2)
     * here.
     * <p>
     * And even more explanations to follow in consecutive
     * paragraphs separated by HTML paragraph breaks.
     *
     * @return Returns the speed factor.
     */
    public abstract double speedFactor();
    public abstract void incrementSpeed(double amount);
    public abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public void move() {
        Vector2D step = direction.multiplyByScalar(currentSpeed);
        position = position.plus(step);
    }

    /**
     * Turn car 45 degree to left.
     */
    public void turnLeft() {
        direction = direction.rotateCC(Math.PI / 4);
    }

    /**
     * Turn car 45 degree to right.
     */
    public void turnRight() {
        direction = direction.rotateCC(- Math.PI / 4);
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getDirection() {
        return direction;
    }

}
