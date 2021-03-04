package Model;
import Model.ICarable;

public interface IRampVehicle extends ICarable {

//     boolean isFullyRaised();

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
}