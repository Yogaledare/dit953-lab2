package Model;
import Observer.EventSource;

public interface IModel {
    void startEngine();
    void stopEngine();
    void gas(int amount);
    void brake(int amount);
    void raise();
    void lower();
    void setTurboOn();
    void setTurboOff();
    EventSource<IVehicle> getModelUpdatedEvent();
    void startTimer();
    void addCar();
    void removeCar();
}
