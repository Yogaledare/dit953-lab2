package Model;

public interface IVehicleState {


    void move(Vehicle context);

    void startEngine(Vehicle context);

    void stopEngine(Vehicle context);

    void gas(Vehicle context, double amount);

    void brake(Vehicle context, double amount);

    void turnLeft(Vehicle context);

    void turnRight(Vehicle context);

}
