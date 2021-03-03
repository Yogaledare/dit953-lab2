package Model.Ramp;

public class RampMiddleState extends RampState implements IRampState{

    public RampMiddleState(Ramp ramp) {
        super(ramp);
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean canStart() {
        return false;
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
    }

}
