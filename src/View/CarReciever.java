package View;

import Observer.EventObserver;
import Observer.EventSource;
import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarReciever implements EventObserver<Car> {

//    private List<JComponent> paintableSubscribers;
//    private List<JComponent> loggableSubscribers;

    private final EventSource<IPaintable> paintHandler = new EventSource<>();
    private final EventSource<ILoggable> loggHandler = new EventSource<>();

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
        paintHandler.publish(paintables);
        loggHandler.publish(loggables);
    }

    public EventSource<IPaintable> getPaintHandler(){
        return paintHandler;
    }

    public EventSource<ILoggable> getLoggHandler(){
        return loggHandler;
    }
}
