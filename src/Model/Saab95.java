package Model;

import java.awt.*;

/**
 * A class representing a Saab95 car.
 */

public class Saab95 extends Car implements ITurboVehicle {

    /**
     * True if turbo is on or not.
     */
    private boolean turboOn;

    /**
     * Constructs a Saab95 object with (hardcoded) presets for modelName, color, enginePower and nrDoors. Initializes
     * turboOn to false.
     */
    Saab95(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, boolean turboOn) {
        super(position, direction, currentSpeed, engineOn, 100, 2, 5, "Saab95", Color.red, 4);
        this.turboOn = turboOn;
    }

    Saab95(Saab95 saab){
        super(saab.getPosition(), saab.getDirection(), saab.getCurrentSpeed(), saab.isEngineOn(),
                100, 2, 5, "Saab95", Color.red, 4);
        this.turboOn = saab.turboOn;
    }

    /**
     * Sets turboOn to true.
     */
    @Override
    public ITurboVehicle setTurboOn() {
        return new Saab95(getPosition(), getDirection(), getCurrentSpeed(), isEngineOn(), true);
    }

    /**
     * Sets turboOn to false.
     */
    @Override
    public ITurboVehicle setTurboOff() {
        return new Saab95(getPosition(), getDirection(), getCurrentSpeed(), isEngineOn(), false);
    }

    /**
     * Returns the value of turboOn.
     * @return the value of turboOn
     */
    public boolean getTurboOn() {
        return turboOn;
    }

    /**
     * Returns the turbo factor of the Model.Model.Saab95.
     * @return the turbo factor of the Model.Model.Saab95
     */
    private double findTurboFactor() {
        if (turboOn) return 1.3;
        return 1;
    }

    /**
     * Returns the speed factor of the Model.Model.Saab95.
     * @return the speed factor of the Model.Model.Saab95
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01 * findTurboFactor();
    }

    @Override
    public IVehicle startEngine(){
        double speed = 0;
        if(!isEngineOn())
            speed = 0.1;
        return new Saab95(getPosition(), getDirection(), speed, true, getTurboOn());
    }

    @Override
    public IVehicle stopEngine(){
        return new Saab95(getPosition(), getDirection(), 0, false, getTurboOn());
    }

    @Override
    protected IVehicle incrementSpeed(double amount, double speedFactor){
        if(isEngineOn()){
            double newSpeed = Vector2D.clamp(getCurrentSpeed() + speedFactor * amount, 0, getEnginePower());
            return new Saab95(getPosition(), getDirection(), newSpeed, isEngineOn(), getTurboOn());
        }
        return new Saab95(this);
    }

    @Override
    protected IVehicle decrementSpeed(double amount, double speedFactor){
        if(isEngineOn()){
            double newSpeed = Vector2D.clamp(getCurrentSpeed() - speedFactor * amount, 0, getEnginePower());
            return new Saab95(getPosition(), getDirection(), newSpeed, isEngineOn(), getTurboOn());
        }
        return new Saab95(this);
    }

    public IVehicle move(){
        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
        Vector2D newPos = getPosition().plus(step);
        return new Saab95(newPos, getDirection(), getCurrentSpeed(), isEngineOn(), getTurboOn());
    }

    @Override
    public IVehicle turnLeft(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(Math.PI / 2);
        return new Saab95(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getTurboOn());
    }

    @Override
    public IVehicle turnRight(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI / 2);
        return new Saab95(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getTurboOn());
    }

    @Override
    public IVehicle turnAround(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI);
        return new Saab95(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getTurboOn());
    }

}

