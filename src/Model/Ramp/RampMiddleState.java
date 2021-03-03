package Model.Ramp;

public class RampMiddleState extends RampState implements IRampState{


    @Override
    public void move(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void startEngine(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void stopEngine(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void gas(IRampVehicleStateRequestHandler context, double amount) {

    }

    @Override
    public void brake(IRampVehicleStateRequestHandler context, double amount) {

    }

    @Override
    public void turnLeft(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void turnRight(IRampVehicleStateRequestHandler context) {

    }

    @Override
    public void lower(IRampVehicleStateRequestHandler context, double amount) {
        context.respondToStateRequestLower(amount);
    }

    @Override
    public void raise(IRampVehicleStateRequestHandler context, double amount) {
        context.respondToStateRequestRaise(amount);
    }
}



/*   public RampMiddleState(Ramp ramp) {
        super(ramp);
    }

    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public void gas() {

    }

    @Override
    public void brake() {

    }

    @Override
    public void lower(double amount) {
        ramp.lower(amount);
        if(ramp.isFullyLowered()){
            ramp.setState(new RampLoweredState(ramp));
        }
    }

    @Override
    public void raise(double amount) {
        ramp.raise(amount);
        if(ramp.isFullyRaised()){
            ramp.setState(new RampRaisedState(ramp));
        }
    }*/


