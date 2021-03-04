package Model.RampVehicle;

import Model.IVehicle;
import Model.Ramp.Ramp;

public abstract class State {

    RampVehicle context;

    public State(RampVehicle context) {
        this.context = context;
    }

    abstract IVehicle startEngine();

    abstract IVehicle stopEngine();

    abstract IVehicle move();

    abstract IVehicle turnLeft();

    abstract IVehicle turnRight();

    abstract IVehicle turnAround();

    abstract boolean isEngineOn();

    abstract IVehicle incrementSpeed(double amount, double speedFactor);

    abstract IVehicle decrementSpeed(double amount, double speedFactor);

    abstract IRampVehicle raise(double amount);

    abstract IRampVehicle lower(double amount);
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



/*    RampVehicle transitionToOnState(RampVehicle context) {
        return new RampVehicle(context.getPosition(), context.getDirection(), context.getCurrentSpeed(), context.offLoweredState, context.ramp);
    }

    RampVehicle transitionToOffLoweredState(RampVehicle context) {
        return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.offLoweredState, context.ramp);
    }

    RampVehicle transitionToOffMiddleState(RampVehicle context) {
        return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.offMiddleState, context.ramp);
    }*/


