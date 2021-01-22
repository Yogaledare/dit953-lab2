import java.awt.*;

public abstract class  Car {
    public String modelName;
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
