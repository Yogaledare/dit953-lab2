package Model.RampVehicle;

import Model.Car;
import Model.IVehicle;
import Model.Vector2D;

import java.awt.*;

public class RampVehicle extends Car implements IRampVehicle {

    State onState = new OnState();
    State offLoweredState = new OffLoweredState();
    State offMiddleState = new OffMiddleState();
    State offRaisedState = new OffRaisedState();

    final State state;
    final Ramp ramp;

    public RampVehicle(Vector2D position, State state, Ramp ramp) {
        super(80, 3, 7, "Scania", Color.blue, 2, position);
        this.state = state;
        this.ramp = ramp;

    }

    @Override
    public IVehicle move() {

    }


    @Override
    public IRampVehicle raise() {
        return null;
    }

    @Override
    public IRampVehicle lower() {
        return null;
    }



}
