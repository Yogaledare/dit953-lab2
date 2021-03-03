package Model;

public class VehicleStateOnStopped implements IVehicleState {


    @Override
    public void move(Vehicle context) {

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

    }

    @Override
    public void turnLeft(Vehicle context) {

    }

    @Override
    public void turnRight(Vehicle context) {

    }


    // sätter turns till att inte göra något då det är mer realistiskt att bilen
    // bara kan svänga när den rullar och inte bara när motorn är igång

}


//    @Override
//    public void turnLeft(Vehicle context) {
//        context.respondToStateRequestTurnLeft();
//    }
//
//    @Override
//    public void turnRight(Vehicle context) {
//        context.respondToStateRequestTurnRight();
//    }
