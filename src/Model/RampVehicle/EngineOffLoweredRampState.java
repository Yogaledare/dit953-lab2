package Model.RampVehicle;

import Model.IVehicle;
import Model.Ramp.Ramp;

public class EngineOffLoweredRampState extends State {

    @Override
    IVehicle startEngine(RampVehicle context) {
        return new RampVehicle(context.getPosition(), context.getDirection(), 0, new EngineOnState(), context.ramp);
    }

    @Override
    IVehicle stopEngine(RampVehicle context) {
        return context;
    }

    @Override
    IVehicle move(RampVehicle context) {
        return context;
    }

    @Override
    IVehicle turnLeft(RampVehicle context) {
        return context;
    }

    @Override
    IVehicle turnRight(RampVehicle context) {
        return context;
    }

    @Override
    IVehicle turnAround(RampVehicle context) {
        return context;
    }

    @Override
    boolean isEngineOn() {
        return false;
    }

    @Override
    IRampVehicle raise(RampVehicle context, double amount) {
        Ramp raisedRamp = new Ramp(context.ramp);
        raisedRamp.raise(amount);
        if (raisedRamp.isFullyLowered()) { // om rampen fortfarande är helt nere. amount var 0
            return context;
        } else {
            return new RampVehicle(context.getPosition(), context.getDirection(), 0, new RaisedRampState(), raisedRamp);
        }
    }

    @Override
    IRampVehicle lower(RampVehicle context, double amount) {
        return context;
    }

    @Override
    IVehicle incrementSpeed(RampVehicle context, double amount, double speedFactor) {
        return context;
    }

    @Override
    IVehicle decrementSpeed(RampVehicle context, double amount, double speedFactor) {
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