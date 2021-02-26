package View;

import Observer.EventObserver;
import Observer.EventHandler;
import Model.Car;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CarReciever implements EventObserver<Car> {

    private List<JComponent> paintableSubscribers;
    private List<JComponent> loggableSubscribers;

    private final EventHandler<IPaintable> paintHandler = new EventHandler<>();
    private final EventHandler<ILoggable> loggHandler = new EventHandler<>();

    public CarReciever(EventHandler<Car> handler){
        handler.addSubscriber(this);
    }

    @Override
    public void actOnPublish(List<? extends Car> cars) {
        List<IPaintable> paintables = new ArrayList<>();
        List<ILoggable> loggables = new ArrayList<>();
        for (Car car : cars) {
            paintables.add(new PaintableWrapper(car));
            loggables.add(new LoggerWrapper(car));
        }
        paintHandler.publish(paintables);
        loggHandler.publish(loggables);
    }

    public EventHandler<IPaintable> getPaintHandler(){
        return paintHandler;
    }

    public EventHandler<ILoggable> getLoggHandler(){
        return loggHandler;
    }
}
