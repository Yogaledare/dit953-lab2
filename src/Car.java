/**
 * @author      Niklas  Axelsson < name @ student.gu.se>
 * @author      Carl    Stewart < name @ student.gu.se>
 * @author      Marcus  Uppström < name @ student.gu.se>
 * @version     0.1                 (current version number of program)
 */

import java.awt.*;

public abstract class  Car {
    /**
     * Car model.
     */
    public String modelName;

    /**
     * Color of car, uses Color.
     */
    public Color color;
    public double currentSpeed;
    public double enginePower;
    public int nrDoors;


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

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

}
