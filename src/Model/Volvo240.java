package Model;

import javax.crypto.spec.IvParameterSpec;
import java.awt.*;

/**
 * A class representing a Volvo240 car.
 */
public class Volvo240 extends Car implements ITrim {


    /**
     * Trim factor, multiplier for speed factor
     */
    private final static double trimFactor = 1.25;

    /**
     * Constructs a Volvo240 object with (hardcoded) presets for modelName, color, enginePower and nrDoors.
     */
    Volvo240(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn) {
        super(position, direction, currentSpeed, engineOn,
                100, 2, 5, "Volvo240", Color.black, 4);
    }

    Volvo240(Volvo240 volvo){
        super(volvo.getPosition(), volvo.getDirection(), volvo.getCurrentSpeed(), volvo.isEngineOn(),
                100, 2, 5, "Volvo240", Color.BLACK, 4);
    }

    /**
     * Returns the speed factor of the Volvo240.
     * @return the speed factor of the Volvo240
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public IVehicle startEngine(){
        double speed = 0;
        if(!isEngineOn())
            speed = 0.1;
        return new Volvo240(getPosition(), getDirection(), speed, true);
    }

    @Override
    public IVehicle stopEngine(){
        return new Volvo240(getPosition(), getDirection(), 0, false);
    }

    @Override
    protected IVehicle incrementSpeed(double amount, double speedFactor){
        if(isEngineOn()){
            double newSpeed = Vector2D.clamp(getCurrentSpeed() + speedFactor * amount, 0, getEnginePower());
            return new Volvo240(getPosition(), getDirection(), newSpeed, isEngineOn());
        }
        return new Volvo240(this);
    }

    @Override
    protected IVehicle decrementSpeed(double amount, double speedFactor){
        if(isEngineOn()){
            double newSpeed = Vector2D.clamp(getCurrentSpeed() - speedFactor * amount, 0, getEnginePower());
            return new Volvo240(getPosition(), getDirection(), newSpeed, isEngineOn());
        }
        return new Volvo240(this);
    }

    @Override
    public IVehicle move(){
        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
        Vector2D newPos = getPosition().plus(step);
        return new Volvo240(newPos, getDirection(), getCurrentSpeed(), isEngineOn());
    }

    @Override
    public IVehicle turnLeft(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(Math.PI / 2);
        return new Volvo240(getPosition(), dir, getCurrentSpeed(), isEngineOn());
    }

    @Override
    public IVehicle turnRight(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI / 2);
        return new Volvo240(getPosition(), dir, getCurrentSpeed(), isEngineOn());
    }

    @Override
    public IVehicle turnAround(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI);
        return new Volvo240(getPosition(), dir, getCurrentSpeed(), isEngineOn());
    }

}

