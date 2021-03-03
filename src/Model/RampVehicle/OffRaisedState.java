package Model.RampVehicle;

import Model.IVehicle;

public class OffRaisedState implements State {

    @Override
    public IVehicle startEngine(IVehicle context) {
        return context;
    }

    @Override
    public IVehicle stopEngine(IVehicle context) {
        return null;
    }

    @Override
    public IVehicle move(IVehicle context) {
        return null;
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
    public boolean isEngineOn() {
        return false;
    }
}
