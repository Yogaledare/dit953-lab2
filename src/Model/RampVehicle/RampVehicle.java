package Model.RampVehicle;

import Model.*;
import Model.Car;
import Model.IVehicle;
import Model.Scania;
import Model.Vector2D;

import java.awt.*;

public class RampVehicle extends Car implements IRampVehicle {

    State onState = new OnState();
    State offLoweredState = new OffLoweredState();
    State offMiddleState = new OffMiddleState();
    State offRaisedState = new OffRaisedState();

    final State state;
    final Ramp ramp;

    public RampVehicle(Vector2D position, Vector2D direction, double currentSpeed, State state, Ramp ramp) {
        super(position, direction, currentSpeed, state.isEngineOn(), 80, 3, 7, "Scania", Color.blue, 2);
        this.state = state;
        this.ramp = ramp;
    }


    @Override
    public IVehicle startEngine() {
        return state.startEngine(this);
    }

    @Override
    public IVehicle stopEngine() {
        return null;
    }

    @Override
    public IVehicle move() {
        return state.move(this);
    }

    @Override
    public IVehicle turnLeft() {
        return null;
    }

    @Override
    public IVehicle turnRight() {
        return null;
    }

    @Override
    public IVehicle turnAround() {
        return null;
    }

    @Override
    public IRampVehicle raise() {
        return null;
    }

    @Override
    public IRampVehicle lower() {
        return null;
    }

    @Override
    protected IVehicle incrementSpeed(double amount, double speedFactor) {
        return null;
    }

    @Override
    protected IVehicle decrementSpeed(double amount, double speedFactor) {
        return null;
    }

}
