package Model;

/**
 * Model.Model.ITurbo is a interface to add a turbo to a Model.Model.Car.
 */
public interface ITurboVehicle extends IVehicle {
    ITurboVehicle setTurboOn();
    ITurboVehicle setTurboOff();
}
