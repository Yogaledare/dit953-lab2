package Model.Ramp;

public class RampRaisedState extends RampState implements IRampState{

    public RampRaisedState(Ramp ramp){
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
        ramp.setState(new RampMiddleState(ramp));
    }

    @Override
    public void raise(double amount) {
        ramp.raise(0);
    }
}
