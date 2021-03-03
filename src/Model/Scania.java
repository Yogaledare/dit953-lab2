package Model;

import Model.Ramp.IRampState;
import Model.Ramp.Ramp;
import Model.Ramp.*;

import java.awt.*;

/**
 * A movable truck with a movable ramp
 */
public class Scania extends Car implements IRampVehicle, IRampVehicleStateRequestHandler {

    /**
     * Ramp component.
     */
    private final Ramp platform;

    private final IRampState state;


    /**
     * Constructs a Scania truck object with the specified modelName, color, enginePower, nrDoors, width and length.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     * @param position Init Scania with startup position.
     */
    Scania(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, IRampState state, Ramp platform) {
        super(position, direction, currentSpeed, engineOn, 80, 3, 7, "Scania", Color.blue, 2);
        this.platform = platform;
        this.state = state;
    }

    Scania(Scania scania){
        super(scania.getPosition(), scania.getDirection(), scania.getCurrentSpeed(), scania.isEngineOn(),
                80, 3, 7, "Scania", Color.blue, 2);
        platform = scania.getPlatform();
        state = scania.getState();
    }

    Scania(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn) {

    }

    /**
     * Returns the speed factor of the truck.
     * @return the speed factor of the truck.
     */
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Raises the ramp to its topmost position. Can not be done if the truck is moving.
     */
    public IVehicle raise(IRampVehicleStateRequestHandler rampState, double amount) {
        return rampState.respondToStateRequestRaise(amount);
    }

    /**
     * Lowers the ramp to its lowest position. Can not be done if the truck is moving.
     */
    public IVehicle lower(IRampVehicleStateRequestHandler rampState, double amount) {
        return rampState.respondToStateRequestLower(amount);

        // platform.getState().lower(amount);
        //if (!isMoving()) {
        //    platform.lower(amount);
        //}
    }

    /**
     * Starts the truck by setting its speed to 0.
     */
//    @Override
//    public IVehicle startEngine(IRampVehicleStateRequestHandler rampState) {
//        return rampState.respondToStateRequestTurnOnEngine();
//
//    }

//    @Override
//    public IVehicle stopEngine(IRampVehicleStateRequestHandler rampState){
//        return rampState.respondToStateRequestTurnOffEngine();
//    }

    @Override
    public IVehicle startEngine() {
        double speed = 0;
        if(!isEngineOn())
            speed = 0.1;
        return new Scania(getPosition(), getDirection(), speed, true, getState(), getPlatform());
    }

    @Override
    public IVehicle stopEngine() {
        return new Scania(getPosition(), getDirection(), 0, false, getState(), getPlatform());
    }

    @Override
    IVehicle incrementSpeed(double amount, double speedFactor) {
        if(isEngineOn()){
            double newSpeed = Vector2D.clamp(getCurrentSpeed() + speedFactor * amount, 0, getEnginePower());
            return new Scania(getPosition(), getDirection(), newSpeed, isEngineOn(), getState(), getPlatform());
        }
        return new Scania(this);
    }

    @Override
    public IVehicle decrementSpeed(double amount, double speedFactor) {
        if(isEngineOn()){
            double newSpeed = Vector2D.clamp(getCurrentSpeed() - speedFactor * amount, 0, getEnginePower());
            return new Scania(getPosition(), getDirection(), newSpeed, isEngineOn(), getState(), getPlatform());
        }
        return new Scania(this);
    }

    @Override
    public IVehicle move() {
        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
        Vector2D newPos = getPosition().plus(step);
        return new Scania(newPos, getDirection(), getCurrentSpeed(), isEngineOn(), getState(), getPlatform());
    }

    @Override
    public IVehicle turnLeft() {
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(Math.PI / 2);
        return new Scania(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getState(), getPlatform());
    }

    @Override
    public IVehicle turnRight() {
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI / 2);
        return new Scania(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getState(), getPlatform());
    }

    @Override
    public IVehicle turnAround() {
        Vector2D dir = getDirection();
        if(isEngineOn())
            dir = getDirection().rotateCC(-Math.PI);
        return new Scania(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getState(), getPlatform());
    }

     @Override
    public void lower(double amount) {

    }

    @Override
    public void raise(double amount) {

    }

    /**
     * Returns true if the platform is fully raised, false otherwise.
     * @return true if the platform is fully raised, false otherwise.
     */
    public boolean isFullyRaised() {
        return platform.isFullyRaised();
    }

    /**
     * Returns true if the platform is fully lowered, false otherwise.
     * @return true if the platform is fully lowered, false otherwise.
     */
    public boolean isFullyLowered() {
        return platform.isFullyLowered();
    }

    private Ramp getPlatform(){
        return platform;
    }

    public IRampState getState(){
        return state;
    }

    @Override
    public IRampVehicle setState(IRampState state) {
        return new Scania(getPosition(), getDirection(), getCurrentSpeed(), isEngineOn(), state, platform);
    }

    @Override
    public IRampVehicle respondToStateRequestMove() {
        Ramp r = new Ramp(this.platform);
        if (r.isFullyLowered() ) {
            move();
        }
        return new Scania(getPosition(), getState(), getPlatform());;
    }

    @Override
    public IRampVehicle respondToStateRequestTurnLeft() {
        return null;
    }

    @Override
    public IRampVehicle respondToStateRequestTurnRight() {
        return null;
    }

    @Override
    public IRampVehicle respondToStateRequestTurnOnEngine() {
        return null;
    }

    @Override
    public IRampVehicle respondToStateRequestTurnOffEngine() {
        return null;
    }

    @Override
    public IRampVehicle respondToStateRequestGas(double amount) {
        return (IRampVehicle) gas(amount);
    }

    @Override
    public IRampVehicle respondToStateRequestBrake(double amount) {
        return (IRampVehicle) brake(amount);
//        IVehicle brakeResult = brake(amount);
    }

    @Override
    public IRampVehicle respondToStateRequestLower(double amount) {
        Ramp newRamp = new Ramp(this.platform);
        IRampState newRampState;

        newRamp.lower(amount);
        if (newRamp.isFullyLowered()) {
            newRampState = new RampDownEngineOffState();
        } else {
            newRampState = state;
        }

        return new Scania(getPosition(), newRampState, newRamp);
    }

    @Override
    public IRampVehicle respondToStateRequestRaise(double amount) {
        Ramp newRamp = new Ramp(this.platform);
        IRampState newRampState;

        newRamp.raise(amount);
        if (newRamp.isFullyRaised()) {
            newRampState = new RampRaisedState();
        } else {
            newRampState = state;
        }

        return new Scania(getPosition(), newRampState, newRamp);
    }


}
