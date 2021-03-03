package Model.RampVehicle;

import Model.Car;

public class RampVehicle extends Car implements IRampVehicle {

    State onState = new OnState();
    State offLoweredState = new OffLoweredState();
    State offMiddleState = new OffMiddleState();
    State offRaisedState = new OffRaisedState();

    final State state;
    final Ramp ramp;

    public Model.IRampVehicle() {


    }





}
