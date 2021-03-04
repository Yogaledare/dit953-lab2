package Model;

public interface IRampVehicleStateRequestHandler {

    IRampVehicle respondToStateRequestMove();
    IRampVehicle respondToStateRequestTurnLeft();
    IRampVehicle respondToStateRequestTurnRight();
    IRampVehicle respondToStateRequestTurnOnEngine();
    IRampVehicle respondToStateRequestTurnOffEngine();
    IRampVehicle respondToStateRequestGas(double amount);
    IRampVehicle respondToStateRequestBrake(double amount);
    IRampVehicle respondToStateRequestLower(double amount);
    IRampVehicle respondToStateRequestRaise(double amount);
    IRampVehicle setState(IRampState state);

}
