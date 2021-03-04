package Model;

public interface IRampVehicle {

    public void lower(double amount);

    public void raise(double amount);

    boolean isFullyRaised();

    IRampVehicle move();
    IRampVehicle turnAround();
    IRampVehicle turnLeft();
    IRampVehicle turnRight();
    IRampVehicle gas(double amount);
    IRampVehicle brake(double amount);
    IRampVehicle startEngine();
    IRampVehicle stopEngine();

}
