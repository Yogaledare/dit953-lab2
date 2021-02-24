package Model;

public interface IModel {
    void startEngine();
    void stopEngine();
    void gas(int amount);
    void brake(int amount);
    void raise();
    void lower();
    void setTurboOn();
    void setTurboOff();
    ObserverHandler getObserverHandler();
    void startTimer();

}
