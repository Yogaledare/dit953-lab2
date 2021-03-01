package View;

import Observer.EventObserver;
import Observer.EventSource;
import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarReciever implements EventObserver<Car> {

//    private List<JComponent> paintableSubscribers;
//    private List<JComponent> loggableSubscribers;

    private final EventSource<IPaintable> paintUpdatedEvent = new EventSource<>();
    private final EventSource<ILoggable> loggUpdatedEvent = new EventSource<>();

    public CarReciever(EventSource<Car> modelUpdatedEvent){
        modelUpdatedEvent.addSubscriber(this);
    }

    @Override
    public void actOnPublish(List</*? extends */Car> cars) {
        List<IPaintable> paintables = new ArrayList<>();
        List<ILoggable> loggables = new ArrayList<>();
        for (Car car : cars) {
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
