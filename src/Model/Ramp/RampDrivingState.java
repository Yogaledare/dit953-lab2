package Model.Ramp;

public class RampDrivingState extends RampState implements IRampState{
    public RampDrivingState(Ramp ramp) {
        super(ramp);
    }

    @Override
    public boolean canMove() {
        return true;
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
        ramp.raise(0);
    }
}
