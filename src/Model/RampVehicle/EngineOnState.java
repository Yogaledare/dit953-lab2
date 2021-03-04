package Model.RampVehicle;

import Model.Vector2D;
import Model.IRampVehicle;

public class EngineOnState extends State {

    @Override
    IRampVehicle startEngine(Scania context) {
        return context;
    }

    @Override
    IRampVehicle stopEngine(Scania context) {
        return new Scania(context.getPosition(), context.getDirection(), 0, new EngineOffLoweredRampState(), context.ramp);
    }

    @Override
    IRampVehicle move(Scania context) {
        Vector2D step = context.getDirection().multiplyByScalar(context.getCurrentSpeed());
        Vector2D newPos = context.getPosition().plus(step);
        return new Scania(newPos, context.getDirection(), context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IRampVehicle turnLeft(Scania context) {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(Math.PI / 2);
        return new Scania(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IRampVehicle turnRight(Scania context) {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(-Math.PI / 2);
        return new Scania(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IRampVehicle turnAround(Scania context) {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(Math.PI );
        return new Scania(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IRampVehicle gas(Scania context, double amount) {
        double newSpeed = context.getIncrementedSpeed(amount, context.findSpeedFactor());
        return new Scania(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }

    @Override
    IRampVehicle brake(Scania context, double amount) {
        double newSpeed = context.getDecrementSpeed(amount, context.findSpeedFactor());
        return new Scania(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }

        @Override
        boolean isEngineOn() {
            return true;
        }


    @Override
    IRampVehicle raise(Scania context, double amount) {
        return context;
    }

    @Override
    IRampVehicle lower(Scania context, double amount) {
        return context;
    }




}



/*    @Override
    IRampVehicle incrementSpeed(RampVehicle context, double amount, double speedFactor) {
        double newSpeed = Vector2D.clamp(context.getCurrentSpeed() + speedFactor * amount, 0, context.getEnginePower());
        return new RampVehicle(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }

    @Override
    IRampVehicle decrementSpeed(RampVehicle context, double amount, double speedFactor) {
        double newSpeed = Vector2D.clamp(context.getCurrentSpeed() - speedFactor * amount, 0, context.getEnginePower());
        return new RampVehicle(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }*/

