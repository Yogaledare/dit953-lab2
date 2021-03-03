package Model;

public interface IRampVehicleState {


    void move(IRampVehicle context);

    void startEngine(IRampVehicle context);

    void stopEngine(IRampVehicle context);

    void lowerRamp(IRampVehicle context);

    void raiseRamp(IRampVehicle context);



}
