package Model.Ramp;

public class RampLoweredState extends RampState implements IRampState{

    public RampLoweredState(Ramp ramp) {
        super(ramp);
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void lower(double amount) {
        ramp.lower(0);
    }

    @Override
    public void raise(double amount) {
        ramp.raise(amount);
        ramp.setState(new RampMiddleState(ramp));
    }
}
