package Model.RampVehicle;

import Model.Ramp;
import Model.IRampVehicle;


public class EngineOffLoweredRampState extends State {

    @Override
    IRampVehicle startEngine(Scania context) {
        return new Scania(context.getPosition(), context.getDirection(), 0.1, new EngineOnState(), context.ramp);
    }

    @Override
    IRampVehicle stopEngine(Scania context) {
        return context;
    }

    @Override
    IRampVehicle move(Scania context) {
        return context;
    }

    @Override
    IRampVehicle turnLeft(Scania context) {
        return context;
    }

    @Override
    IRampVehicle turnRight(Scania context) {
        return context;
    }

    @Override
    IRampVehicle turnAround(Scania context) {
        return context;
    }

    @Override
    IRampVehicle gas(Scania context, double amount) {
        return context;
    }

    @Override
    IRampVehicle brake(Scania context, double amount) {
        return context;
    }

    @Override
    boolean isEngineOn() {
        return false;
    }


    @Override
    IRampVehicle raise(Scania context, double amount) {
        Ramp raisedRamp = new Ramp(context.ramp);
        raisedRamp.raise(amount);
        if (raisedRamp.isFullyLowered()) { // om rampen fortfarande är helt nere. amount var 0
            return context;
        } else {
//            System.out.println("bytt till raised state");
//            System.out.println("vinkel: " + raisedRamp.getRampAngle());
            return new Scania(context.getPosition(), context.getDirection(), 0, new RaisedRampState(), raisedRamp);
        }
    }

    @Override
    IRampVehicle lower(Scania context, double amount) {
        return context;
    }




}


/*    @Override
    IRampVehicle incrementSpeed(RampVehicle context, double amount, double speedFactor) {
        return context;
    }

    @Override
    IRampVehicle decrementSpeed(RampVehicle context, double amount, double speedFactor) {
        return context;
    }*/



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