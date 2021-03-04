package Model.RampVehicle;

import Model.IVehicle;
import Model.Vector2D;

public class EngineOnState extends State {

    public EngineOnState(RampVehicle context) {
        super(context);
    }

    @Override
    IVehicle startEngine() {
        return context;
    }

    @Override
    IVehicle stopEngine() {
        return new RampVehicle(context.getPosition(), context.getDirection(), 0, context.engineOffLoweredRampState, context.ramp);
    }

    @Override
    IVehicle move() {
        Vector2D step = context.getDirection().multiplyByScalar(context.getCurrentSpeed());
        Vector2D newPos = context.getPosition().plus(step);
        return new RampVehicle(newPos, context.getDirection(), context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IVehicle turnLeft() {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(Math.PI / 2);
        return new RampVehicle(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IVehicle turnRight() {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(-Math.PI / 2);
        return new RampVehicle(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IVehicle turnAround() {
        Vector2D currentDirection = context.getDirection();
        Vector2D newDirection = currentDirection.rotateCC(Math.PI );
        return new RampVehicle(context.getPosition(), newDirection, context.getCurrentSpeed(), context.state, context.ramp);
    }

    @Override
    IRampVehicle raise(double amount) {
        return context;
    }

    @Override
    IRampVehicle lower(double amount) {
        return context;
    }

    @Override
    boolean isEngineOn() {
        return true;
    }

    @Override
    IVehicle incrementSpeed(double amount, double speedFactor) {
        double newSpeed = Vector2D.clamp(context.getCurrentSpeed() + speedFactor * amount, 0, context.getEnginePower());
        return new RampVehicle(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }

    @Override
    IVehicle decrementSpeed(double amount, double speedFactor) {
        double newSpeed = Vector2D.clamp(context.getCurrentSpeed() - speedFactor * amount, 0, context.getEnginePower());
        return new RampVehicle(context.getPosition(), context.getDirection(), newSpeed, context.state, context.ramp);
    }
}
