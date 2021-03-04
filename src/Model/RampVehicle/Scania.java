package Model.RampVehicle;

import Model.*;

import java.awt.*;

public class Scania extends Car implements IRampVehicle {

    final State state;
    final Ramp ramp;

    public Scania(Vector2D position, Vector2D direction, double speed, State state, Ramp ramp) {
        super(
                position, direction,
                speed, state.isEngineOn(),
                80, 3, 7, "Scania", Color.blue, 2);
        this.state = state;
        this.ramp = ramp;
    }

    @Override
    protected double getIncrementedSpeed(double amount, double speedFactor) {
        return super.getIncrementedSpeed(amount, speedFactor);
    }

    @Override
    protected double getDecrementSpeed(double amount, double speedFactor) {
        return super.getDecrementSpeed(amount, speedFactor);
    }

    @Override
    protected double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public IRampVehicle startEngine() { return state.startEngine(this); }

    @Override
    public IRampVehicle stopEngine() {
        return state.stopEngine(this);
    }

    @Override
    public IRampVehicle move() {
        return state.move(this);
    }

    @Override
    public IRampVehicle turnLeft() {
        return state.turnLeft(this);
    }

    @Override
    public IRampVehicle turnRight() {
        return state.turnRight(this);
    }

    @Override
    public IRampVehicle turnAround() {
        return state.turnAround(this);
    }

    @Override
    public IRampVehicle raise(double amount) {
        return state.raise(this, amount);
    }

    @Override
    public IRampVehicle lower(double amount) {
        return state.lower(this, amount);
    }

    @Override
    public boolean isEngineOn() {
        return state.isEngineOn();
    }

    @Override
    public <T extends ITransportable> T follow(ITransporter<T> transporter) {
        return null;
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

