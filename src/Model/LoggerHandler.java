package Model;

import View.ILoggable;
import View.IPaintable;

import java.util.ArrayList;
import java.util.List;



public class LoggerHandler {
    private List<LoggerObserver> subscribers = new ArrayList<>();

    public void addSubscriber(LoggerObserver observer){
        subscribers.add(observer);
    }

    public void removeSubscriber(LoggerObserver observer){
        subscribers.remove(observer);
    }

    public void publish(List<? extends ILoggable> loggables){
        for (LoggerObserver observer : subscribers) {
            observer.actOnPublish(loggables);
        }
    }

    public int getSize() {
        return subscribers.size();
    }
}
