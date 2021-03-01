package Model;

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
        return;
    }

    @Override
    public void raise(double amount) {

    }
}
