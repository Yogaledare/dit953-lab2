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

    private EventHandler<IPaintable> paintHandler = new EventHandler<>();
    private EventHandler<ILoggable> loggHandler = new EventHandler<>();

    @Override
    public void actOnPublish(List<? extends Car> cars) {
        List<IPaintable> paintables = new ArrayList<>();
        List<ILoggable> loggables = new ArrayList<>();
        for (Car car : cars) {
            paintables.add(new PaintableWrapper(car));
            loggables.add(new LoggerWrapper(car));
        }

        //draw.publish(paintables);
        //log.publish(loggables);
    }


    public void addPaintableSubscriber(JComponent subscriber) {
        paintableSubscribers.add(subscriber);
    }

    public void addLoggableSubscriber(JComponent subscriber) {
        loggableSubscribers.add(subscriber);
    }



    public void notifySubscribers () {
        for (JComponent paintableSubscriber : paintableSubscribers) {

        }
    }

}
