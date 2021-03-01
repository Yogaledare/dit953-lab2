package View;

import Model.IMovable;
import Observer.EventObserver;
import Observer.EventSource;
import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarReciever implements EventObserver<IMovable> {

    private final EventSource<IPaintable> paintUpdatedEvent = new EventSource<>();
    private final EventSource<ILoggable> loggUpdatedEvent = new EventSource<>();

    public CarReciever(EventSource<IMovable> modelUpdatedEvent){
        modelUpdatedEvent.addSubscriber(this);
    }

    @Override
    public void actOnPublish(List</*? extends */IMovable> cars) {
        List<IPaintable> paintables = new ArrayList<>();
        List<ILoggable> loggables = new ArrayList<>();
        for (IMovable car : cars) {
            paintables.add(new PaintableWrapper(car));
            loggables.add(new LoggerWrapper(car));
        }
        paintUpdatedEvent.publish(paintables);
        loggUpdatedEvent.publish(loggables);
    }

    public EventSource<IPaintable> getPaintUpdatedEvent(){
        return paintUpdatedEvent;
    }

    public EventSource<ILoggable> getLoggUpdatedEvent(){
        return loggUpdatedEvent;
    }
}
