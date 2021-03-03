package Model;

public class VehicleStateOnMoving implements IVehicleState {


    @Override
    public void move(Vehicle context) {
        context.respondToStateRequestMove();
    }

    @Override
    public void startEngine(Vehicle context) {

    }

    @Override
    public void stopEngine(Vehicle context) {
        context.respondToStateRequestTurnOffEngine();
    }

    @Override
    public void gas(Vehicle context, double amount) {
        context.respondToStateRequestGas(amount);
    }

    @Override
    public void brake(Vehicle context, double amount) {
        context.respondToStateRequestBrake(amount);
    }

    @Override
    public void turnLeft(Vehicle context) {
        context.respondToStateRequestTurnLeft();
    }

    @Override
    public void turnRight(Vehicle context) {
        context.respondToStateRequestTurnRight();
    }


}
