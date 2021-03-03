package Model.Ramp;

import Model.Model;

public interface IRampState {

    void move(IRampVehicleStateRequestHandler context);

    void startEngine(IRampVehicleStateRequestHandler context);
    void stopEngine(IRampVehicleStateRequestHandler context);

    void gas(IRampVehicleStateRequestHandler context, double amount);
    void brake(IRampVehicleStateRequestHandler context, double amount);

    void turnLeft(IRampVehicleStateRequestHandler context);
    void turnRight(IRampVehicleStateRequestHandler context);

    void lower(IRampVehicleStateRequestHandler context, double amount);
    void raise(IRampVehicleStateRequestHandler context, double amount);
}




/*
kör
står stilla, ramp nere
står stilla, ramp halvuppe
står stilla, ramp uppe
*/
/*
abstract class State {
    private Car car;

    public State(Car car) {
        this.car = car;

    }

    public abstract void move();

    public abstract void stop();

    public abstract void raiseFlak();


}
class MovingState extends State {

    @Override
    public void move() {
        // logik för att mova
    }

    @Override
    public void stop() {
        car.setCurrentSpeed(0);
        car.changeState(new StoppedState(car));
    }
}
class Car {
    public void changeState(State state) {
        this.state = state;
    }
}
*/
