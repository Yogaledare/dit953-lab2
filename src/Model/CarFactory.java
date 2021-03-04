package Model;

import Model.RampVehicle.EngineOffLoweredRampState;
import Model.RampVehicle.Scania;
import Model.RampVehicle.State;

public class CarFactory {
    public static ITrim createVolvo240(Vector2D position, Vector2D direction, double speed, boolean engineOn){
        return new Volvo240(position, direction, speed, engineOn);
    }

    public static ITurboVehicle createSaab95(Vector2D position, Vector2D direction, double speed, boolean engineOn, boolean turboOn){
        return new Saab95(position, direction, speed, engineOn, turboOn);
    }

    public static IRampVehicle createScania(Vector2D position, Vector2D direction, double speed) {
        return new Scania(position, direction, speed, new EngineOffLoweredRampState(), new Ramp(70, 1));

    }
}
