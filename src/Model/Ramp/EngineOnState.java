package Model.Ramp;

import Model.IRampVehicleStateRequestHandler;

public class EngineOnState implements IRampState {


    @Override
    public void move(IRampVehicleStateRequestHandler context) {
        context.respondToStateRequestMove();
    }

    @Override
    public void startEngine(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void stopEngine(IRampVehicleStateRequestHandler context) {
        context.respondToStateRequestTurnOffEngine();
    }

    @Override
    public void gas(IRampVehicleStateRequestHandler context, double amount) {
        context.respondToStateRequestGas(amount);
    }

    @Override
    public void brake(IRampVehicleStateRequestHandler context, double amount) {
        context.respondToStateRequestBrake(amount);
    }

    @Override
    public void turnLeft(IRampVehicleStateRequestHandler context) {
        context.respondToStateRequestTurnLeft();
    }

    @Override
    public void turnRight(IRampVehicleStateRequestHandler context) {
        context.respondToStateRequestTurnRight();
    }

    @Override
    public void lower(IRampVehicleStateRequestHandler context, double amount) {

    }

    @Override
    public void raise(IRampVehicleStateRequestHandler context, double amount) {

    }
}
