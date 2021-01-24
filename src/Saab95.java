import java.awt.*;

/**
 * A class representing a Saab95 car.
 */
public class Saab95 extends Car implements AuxTurbo {

    /**
     * Flag to indicate if turbo is on or not.
     */
    private boolean turboOn;

    /**
     * Constructs a Saab95 object by calling its parent constructor with (hardcoded) presets for modelName, color,
     * enginePower and nrDoors. Initializes turboOn to false.
     */
    public Saab95() {
        super("Saab95", Color.red, 125, 2);
        turboOn = false;
    }

    /**
     * Sets turboOn to true.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets turboOn to false.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Returns the speed factor of the Saab95.
     * @return the speed factor of the Saab95
     */
    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01 * findTurboFactor();
    }

    /**
     * Returns the turbo factor of the Saab95.
     * @returnthe turbo factor of the Saab95
     */
    public double findTurboFactor() {
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
