package Model;
import Observer.EventHandler;
public interface IModel {

    void startEngine();
    void stopEngine();
    void gas(int amount);
    void brake(int amount);
    void raise();
    void lower();
    void setTurboOn();
    void setTurboOff();
    EventHandler<Car> getHandler();
    void startTimer();

}
