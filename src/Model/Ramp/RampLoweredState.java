package Model.Ramp;

public class RampLoweredState extends RampState implements IRampState{

    public RampLoweredState(Ramp ramp) {
        super(ramp);
    }

    @Override
    public void move() {

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
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void lower(double amount) {
        ramp.lower(amount);
    }

    @Override
    public void raise(double amount) {
        ramp.raise(amount);
    }
}
