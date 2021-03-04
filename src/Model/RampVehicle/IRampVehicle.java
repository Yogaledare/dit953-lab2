package Model.RampVehicle;

import Model.IVehicle;

public interface IRampVehicle extends IVehicle {


    IRampVehicle raise(double amount);

    IRampVehicle lower(double amount);

    boolean isEngineOn();




}
