package Model;

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

        }
    }

    @Override
    public void raise(double amount) {

    }

}
