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
    EventHandler<EventObserver<IPaintable>,IPaintable> getPaintHandler();
    EventHandler<EventObserver<ILoggable>,ILoggable> getLogHandler();
    void startTimer();

}
