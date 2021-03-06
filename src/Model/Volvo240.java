package Model;

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
    public ITrim startEngine(){
        double speed = 0;
        if(!isEngineOn())
            speed = 0.1;
        return new Volvo240(getPosition(), getDirection(), speed, true);
    }

    @Override
    public ITrim stopEngine(){
        return new Volvo240(getPosition(), getDirection(), 0, false);
    }

    @Override
    public ITrim gas(double amount) {
        return new Volvo240(getPosition(), getDirection(),
                getIncrementedSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
                isEngineOn());
    }

    @Override
    public ITrim brake(double amount) {
        return new Volvo240(getPosition(), getDirection(),
                getDecrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
                isEngineOn());
    }

    @Override
    public ITrim move(){
        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
        Vector2D newPos = getPosition().plus(step);
        return new Volvo240(newPos, getDirection(), getCurrentSpeed(), isEngineOn());
    }

    @Override
    public ITrim turnLeft(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(Math.PI / 2);
        return new Volvo240(getPosition(), dir, getCurrentSpeed(), isEngineOn());
    }

    @Override
    public ITrim turnRight(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI / 2);
        return new Volvo240(getPosition(), dir, getCurrentSpeed(), isEngineOn());
    }

    @Override
    public ITrim turnAround(){
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI);
        return new Volvo240(getPosition(), dir, getCurrentSpeed(), isEngineOn());
    }

    @Override
    public Volvo240 getCarriedTo(Vector2D position, Vector2D direction) {
        return new Volvo240(position, direction, getCurrentSpeed(), isEngineOn());
    }

/*    @Override
    public <T extends ITransportable> ITransportable follow(ITransporter<T> transporter) {
        return new Volvo240(transporter.getPosition(), transporter.getDirection(), getCurrentSpeed(), isEngineOn());
    }*/
}

