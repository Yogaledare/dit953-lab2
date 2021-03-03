package Model;

public class VehicleStateOff implements IVehicleState {


    @Override
    public void move(Vehicle context) {

    }

    @Override
    public void startEngine(Vehicle context) {
        context.respondToStateRequestTurnOnEngine();
    }

    @Override
    public void stopEngine(Vehicle context) {

    }

    @Override
    public void gas(Vehicle context, double amount) {

    }

    @Override
    public void brake(Vehicle context, double amount) {

    }

    @Override
    public void turnLeft(Vehicle context) {

    }

    @Override
    public void turnRight(Vehicle context) {

    }


}
