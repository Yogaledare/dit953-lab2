package Model.RampVehicle;

import Model.IVehicle;

public class RaisedRampState extends State {

    public RaisedRampState(RampVehicle context) {
        super(context);
    }

    @Override
    IVehicle startEngine() {
        return context;
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


