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
    private String modelName;

    /**
     * Color of car
     */
    private Color color;

    /**
     * Current speed valid interval from 0 to 1.0
     */
    private double currentSpeed;

    /**
     * Engine power
     */
    private double enginePower;

    /**
     * Number of doors
     */
    private int nrDoors;



    private Vector2D position;
    private Vector2D direction;



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
     * Numbers of doors the car have.
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns how much power the car have.
     * @return power of the car
     */
    public double getEnginePower() { return enginePower; }


// todo är det sant att speed är mellan 0.1 och 1.0?

    /**
     * Returns current speed
     *
     * @return the speed from 0.1 to 1.0
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Color of the car
     * @return cars paintwork
     */
//    public void setCurrentSpeed(double speed){ currentSpeed = speed; }

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
     * Car model
     * @return what kind of model it is.
     */
    public String getModelName() {
        return modelName;
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

    public abstract double findSpeedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = (Math.min(getCurrentSpeed() + findSpeedFactor() * amount, enginePower));
    }

    public void decrementSpeed(double amount) {
        currentSpeed = (Math.max(getCurrentSpeed() - findSpeedFactor() * amount, 0));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(clamp(amount, 0, 1));
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(clamp(amount, 0, 1));
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

    private double clamp(double d, double min, double max){
        d = Math.max(d, min);
        return Math.min(d, max);
    }

    public Vector2D getPosition() {
        return position;
    }

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

