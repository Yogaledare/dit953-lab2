package Model.Ramp;

import Model.IRampVehicleStateRequestHandler;

public class EngineOffRampDownState implements IRampState {


    @Override
    public void move(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void startEngine(IRampVehicleStateRequestHandler context) {
        context.respondToStateRequestTurnOnEngine();

    }

    @Override
    public void stopEngine(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void gas(IRampVehicleStateRequestHandler context, double amount) {

    }

    @Override
    public void brake(IRampVehicleStateRequestHandler context, double amount) {

    }

    @Override
    public void turnLeft(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void turnRight(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void lower(IRampVehicleStateRequestHandler context, double amount) {

    }

    @Override
    public void raise(IRampVehicleStateRequestHandler context, double amount) {
        context.respondToStateRequestRaise(amount);
    }
}

