package Model;

import View.ILoggable;

import java.util.Collection;

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
    EventHandler<EventObserver<ILoggable>,ILoggable> getLoggerHandler();
    void startTimer();

}
