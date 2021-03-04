package Model;

/**
 * Model.Model.ITurbo is a interface to add a turbo to a Model.Model.Car.
 */
public interface ITurboVehicle extends ICarable {
    ITurboVehicle setTurboOn();
    ITurboVehicle setTurboOff();

    ITurboVehicle move();
    ITurboVehicle turnAround();
    ITurboVehicle turnLeft();
    ITurboVehicle turnRight();
    ITurboVehicle gas(double amount);
    ITurboVehicle brake(double amount);
    ITurboVehicle startEngine();
    ITurboVehicle stopEngine();
}
