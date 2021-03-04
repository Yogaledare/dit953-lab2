package Model.RampVehicle;

import Model.IVehicle;

public class EngineOffLoweredRampState extends State {

    public EngineOffLoweredRampState(RampVehicle context) {
        super(context);
    }

    @Override
    IVehicle startEngine() {
        return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.engineOnState, context.ramp);
    }

    @Override
    IVehicle stopEngine() {
        return context;
    }

    @Override
    IVehicle move() {
        return context;
    }

    @Override
    IVehicle turnLeft() {
        return context;
    }

    @Override
    IVehicle turnRight() {
        return context;
    }

    @Override
    IVehicle turnAround() {
        return context;
    }

    @Override
    boolean isEngineOn() {
        return false;
    }

    @Override
    IVehicle incrementSpeed(double amount, double speedFactor) {
        return context;
    }

    @Override
    IVehicle decrementSpeed(double amount, double speedFactor) {
        return context;
    }
}


