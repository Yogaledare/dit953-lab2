package View;

import Model.IVehicle;
import Observer.EventObserver;
import Observer.EventSource;

import java.util.ArrayList;
import java.util.List;

public class CarReciever implements EventObserver<IVehicle> {

    private final EventSource<IPaintable> paintUpdatedEvent = new EventSource<>();
    private final EventSource<ILoggable> loggUpdatedEvent = new EventSource<>();

    public CarReciever(EventSource<IVehicle> modelUpdatedEvent){
        modelUpdatedEvent.addSubscriber(this);
    }

    @Override
    public void actOnPublish(List</*? extends */IVehicle> cars) {
        List<IPaintable> paintables = new ArrayList<>();
        List<ILoggable> loggables = new ArrayList<>();
        for (IVehicle car : cars) {
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
