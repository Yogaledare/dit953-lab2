package View;

import Model.ICarable;
import Model.IVehicle;
import Observer.EventObserver;
import Observer.EventSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarReciever implements EventObserver<ICarable> {

    private final EventSource<IPaintable> paintUpdatedEvent = new EventSource<>();
    private final EventSource<ILoggable> loggUpdatedEvent = new EventSource<>();

    public CarReciever(EventSource<ICarable> modelUpdatedEvent){
        modelUpdatedEvent.addSubscriber(this);
    }

    @Override
    public void actOnPublish(Collection<? extends ICarable> cars) {
        List<IPaintable> paintables = new ArrayList<>();
        List<ILoggable> loggables = new ArrayList<>();
        for (ICarable car : cars) {
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
