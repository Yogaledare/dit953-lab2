package Model.Ramp;

import Model.IRampVehicleStateRequestHandler;
import Model.IVehicle;

public class RampRaisedState implements IRampState{


    @Override
    public IVehicle move(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public IVehicle startEngine(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public IVehicle stopEngine(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public IVehicle gas(IRampVehicleStateRequestHandler context, double amount) {
        return context.respondToStateRequestGas(amount);
    }

    @Override
    public IVehicle brake(IRampVehicleStateRequestHandler context, double amount) {
        return context.respondToStateRequestBrake(amount);
    }

    @Override
    public IVehicle turnLeft(IRampVehicleStateRequestHandler context) {
        return context.respondToStateRequestTurnLeft();
    }

    @Override
    public IVehicle turnRight(IRampVehicleStateRequestHandler context) {
        return context.respondToStateRequestTurnRight();
    }

    @Override
    public IVehicle lower(IRampVehicleStateRequestHandler context, double amount) {
        return context.respondToStateRequestLower(amount);
    }

    @Override
    public IVehicle raise(IRampVehicleStateRequestHandler context, double amount) {
        return context.respondToStateRequestLower(amount);
    }
}



/*
    public RampRaisedState(Ramp ramp){
        super(ramp);
    }

    @Override
    public void startEngine() {
        // not possible to start when ramp is up
    }

    @Override
    public void stopEngine() {
        this.stopEngine();
    }

    @Override
    public void gas() {
        this.gas();
    }

    @Override
    public void brake() {
        this.brake();
    }

    @Override
    public void lower(double amount) {
        ramp.lower(amount);
        ramp.setState(new RampMiddleState(ramp));
    }

    @Override
    public void raise(double amount) {
        ramp.raise(0);
    }*/


