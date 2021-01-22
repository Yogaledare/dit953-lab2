import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;
    
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setName("Saab95");
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

}
