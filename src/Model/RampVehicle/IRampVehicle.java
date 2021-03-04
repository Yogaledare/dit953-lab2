package Model.RampVehicle;

import Model.ICarable;

public interface IRampVehicle extends ICarable {


    IRampVehicle move();

    IRampVehicle turnAround();

    IRampVehicle turnLeft();

    IRampVehicle turnRight();

    IRampVehicle gas(double amount);

    IRampVehicle brake(double amount);

    IRampVehicle startEngine();

    IRampVehicle stopEngine();



    IRampVehicle raise(double amount);

    IRampVehicle lower(double amount);




//    boolean isEngineOn();

//    IRampVehicle incrementSpeed(double amount, double speedFactor);

//    IRampVehicle decrementSpeed(double amount, double speedFactor);




}
