package Model.Ramp;

public class RampDrivingState extends RampState implements IRampState {
    public RampDrivingState(Ramp ramp) {
        super(ramp);
    }

    @Override
    public void move() {
        this.move();
    }

    @Override
    public void startEngine() {
        this.startEngine();

    }

    @Override
    public void stopEngine() {
        this.stopEngine();
    }

    @Override
    public void gas() {
        this.gas();
    }

    @Override
    public void brake() {
        this.brake();
    }

    @Override
    public void turnLeft() {
        this.turnLeft();
    }

    @Override
    public void turnRight() {
        this.turnRight();
    }

    @Override
    public void lower(double amount) {
        // not possible to change ramp when car is moving.
        // ramp.lower(0);
    }

    @Override
    public void raise(double amount) {
        // not possible to change ramp when car is moving.
        // ramp.raise(0);
    }
}
