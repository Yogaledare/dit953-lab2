package Model.RampVehicle;

import Model.IVehicle;

public interface State {


    IVehicle startEngine(IVehicle context);

    IVehicle stopEngine(IVehicle context);

    IVehicle move(IVehicle context);

    IVehicle turnLeft();

    IVehicle turnRight();

    IVehicle turnAround();

    IRampVehicle raise();

    IRampVehicle lower();

    boolean isEngineOn();







}
