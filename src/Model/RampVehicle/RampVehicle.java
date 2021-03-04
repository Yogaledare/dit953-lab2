package Model.RampVehicle;

import Model.Car;
import Model.IVehicle;
import Model.Ramp.Ramp;
import Model.Vector2D;

import java.awt.*;

public class RampVehicle extends Car implements IRampVehicle {

    State engineOnState = new EngineOnState(this);
    State engineOffLoweredRampState = new EngineOffLoweredRampState(this);
    State raisedRampState = new RaisedRampState(this);

    final State state;
    final Ramp ramp;

    public RampVehicle(Vector2D position, Vector2D direction, double speed, State state, Ramp ramp) {
        super(
                position, direction,
                speed, state.isEngineOn(),
                80, 3, 7, "Scania", Color.blue, 2);
        this.state = state;
        this.ramp = ramp;
    }


    @Override
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public IVehicle startEngine() {
        return state.startEngine();
    }

    @Override
    public IVehicle stopEngine() {
        return state.stopEngine();
    }

    @Override
    public IVehicle move() {
        return state.move();
    }

    @Override
    public IVehicle turnLeft() {
        return state.turnLeft();
    }

    @Override
    public IVehicle turnRight() {
        return state.turnRight();
    }

    @Override
    public IVehicle turnAround() {
        return state.turnAround();
    }

    @Override
    public IRampVehicle raise(double amount) {
        return state.raise(amount);
    }

    @Override
    public IRampVehicle lower(double amount) {
        return state.lower(amount);
    }

    @Override
    public boolean isEngineOn() {
        return state.isEngineOn();
    }

    @Override
    protected IVehicle incrementSpeed(double amount, double speedFactor) {
        return state.incrementSpeed(amount, speedFactor);
    }

    @Override
    protected IVehicle decrementSpeed(double amount, double speedFactor) {
        return state.decrementSpeed(amount, speedFactor);
    }

}


/*    public RampVehicle(RampVehicle rampVehicle) {
        super(
                rampVehicle.getPosition(), rampVehicle.getDirection(),
                rampVehicle.getCurrentSpeed(), rampVehicle.isEngineOn(),
                80, 3, 7, "Scania", Color.blue, 2);
        this.ramp = rampVehicle.ramp;
        this.state = rampVehicle.state;
    }*/



//    State offMiddleState = new OffMiddleState(this);

