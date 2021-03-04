package Model.RampVehicle;

import Model.IVehicle;
import Model.Ramp.Ramp;

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
    IRampVehicle raise(double amount) {
        Ramp raisedRamp = new Ramp(context.ramp);
        raisedRamp.raise(amount);
        if (raisedRamp.isFullyLowered()) { // om rampen fortfarande är helt nere. amount var 0
            return context;
        } else {
            return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.raisedRampState, raisedRamp);
        }
    }

    @Override
    IRampVehicle lower(double amount) {
        return context;
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


/*


    IRampVehicle raise(double amount) {
        Ramp raisedRamp = new Ramp(context.ramp);
        raisedRamp.raise(amount);
        if (raisedRamp.isFullyLowered()) { // om rampen fortfarande är helt nere. amount var 0
            return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.engineOffLoweredRampState, raisedRamp);
        } else  {
            return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.raisedRampState, raisedRamp);
        }
    }

    IRampVehicle lower(double amount) {
        Ramp loweredRamp = new Ramp(context.ramp);
        loweredRamp.raise(amount);
        if (loweredRamp.isFullyLowered()) { // om rampen efter flyttning är helt nere
            return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.engineOffLoweredRampState, loweredRamp);
        } else {
            return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.raisedRampState, loweredRamp);
        }
    }


    */