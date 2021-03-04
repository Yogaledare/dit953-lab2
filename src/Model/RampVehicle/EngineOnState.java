package Model.RampVehicle;

import Model.IVehicle;
import Model.Vector2D;

public class EngineOnState extends State {

    @Override
    IVehicle startEngine(RampVehicle context) {
        return context;
    }

    @Override
    IVehicle stopEngine(RampVehicle context) {
        return new RampVehicle(context.getPosition(), context.getDirection(), 0, new EngineOffLoweredRampState(), context.ramp);
    }

    @Override
    IVehicle move(RampVehicle context) {
        Vector2D step = context.getDirection().multiplyByScalar(context.getCurrentSpeed());
        Vector2D newPos = context.getPosition().plus(step);
        return new RampVehicle(newPos, context.getDirection(), context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IVehicle turnLeft(RampVehicle context) {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(Math.PI / 2);
        return new RampVehicle(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IVehicle turnRight(RampVehicle context) {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(-Math.PI / 2);
        return new RampVehicle(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IVehicle turnAround(RampVehicle context) {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(Math.PI );
        return new RampVehicle(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IRampVehicle raise(RampVehicle context, double amount) {
        return context;
    }

    @Override
    IRampVehicle lower(RampVehicle context, double amount) {
        return context;
    }

    @Override
    boolean isEngineOn() {
        return true;
    }

    @Override
    IVehicle incrementSpeed(RampVehicle context, double amount, double speedFactor) {
        double newSpeed = Vector2D.clamp(context.getCurrentSpeed() + speedFactor * amount, 0, context.getEnginePower());
        return new RampVehicle(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }

    @Override
    IVehicle decrementSpeed(RampVehicle context, double amount, double speedFactor) {
        double newSpeed = Vector2D.clamp(context.getCurrentSpeed() - speedFactor * amount, 0, context.getEnginePower());
        return new RampVehicle(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }
}
