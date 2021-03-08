package Model.Scania;

import Model.IRampVehicle;

public abstract class State {


    abstract IRampVehicle startEngine(Scania context);

    abstract IRampVehicle stopEngine(Scania context);

    abstract IRampVehicle move(Scania context);

    abstract IRampVehicle turnLeft(Scania context);

    abstract IRampVehicle turnRight(Scania context);

    abstract IRampVehicle turnAround(Scania context);

    abstract IRampVehicle gas(Scania context, double amount);

    abstract IRampVehicle brake(Scania context, double amount);

    abstract boolean isEngineOn();


    abstract IRampVehicle raise(Scania context, double amount);

    abstract IRampVehicle lower(Scania context, double amount);
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


