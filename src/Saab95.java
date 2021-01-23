import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;


    public Saab95() {
        super("Saab95", Color.red, 125, 2);
        turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01 * findTurboFactor();
    }

    private double findTurboFactor() {
        if (turboOn) return 1.3;
        return 1;
    }

}




/*    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + findSpeedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - findSpeedFactor() * amount);
    }*/

/*    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }*/



/*    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }*/
