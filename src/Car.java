/**
 * @author      Niklas  Axelsson < name @ student.gu.se>
 * @author      Carl    Stewart < name @ student.gu.se>
 * @author      Marcus  Uppström < name @ student.gu.se>
 * @version     0.1                 (current version number of program)
 */

import java.awt.*;

public abstract class  Car implements Movable {
    /**
     * Car model.
     */
    private String modelName;

    /**
     * Color of car, uses Color.
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


    /**
     * Returns number of doors the car have
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }


    /**
     * Returns how much power the car have.
     * @return power of the car
     */
    public double getEnginePower() { return enginePower; }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Returns current speed
     * @return
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed){ currentSpeed = speed; }

    public Color getColor(){
        return color;
    }

    /**
     * Sets RAL color of car                                (1)
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

    public void startEngine(){
        currentSpeed = 0.1;
    }

    // comment added
    public void stopEngine(){
        currentSpeed = 0;
    }

    public String getModelName() {
        return modelName;
    }

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
        incrementSpeed(clamp(amount, 0, 1));
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(clamp(amount, 0, 1));
    }

    public void move() {
        Vector2D step = direction.multiplyByScalar(currentSpeed);
        position = position.plus(step);
    }

    public void turnLeft() {
        direction = direction.rotateCC(Math.PI / 4);
    }

    public void turnRight() {
        direction = direction.rotateCC(- Math.PI / 4);
    }

    private double clamp(double d, double min, double max){
        d = Math.max(d, min);
        return Math.min(d, max);
    }

}
