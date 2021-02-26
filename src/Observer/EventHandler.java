package Observer;

import java.util.List;
import java.util.ArrayList;

public class EventHandler<T> {
    private final List<EventObserver<T>> subscribers = new ArrayList<>();

    /**
     * Adds a new subscriber to an object that is observable,
     * for example ILoggable or IPaintable
     * @param observer added as a listener to observable object.
     */
    public void addSubscriber(EventObserver<T> observer){
        subscribers.add(observer);
    }

    /**
     * Unsubscribe from an observable object.
     * @param observer to which unsubscribe from.
     */
    public void removeSubscriber(EventObserver<T> observer){
        subscribers.remove(observer);
    }

    /**
     * Notifies all observers that a event occurred.
     * @param publisher, all objects that inherits the interface
     */
    public void publish(List<? extends T> publisher){
        for (EventObserver<T> observer : subscribers) {
            observer.actOnPublish(publisher);
        }
    }

    /**
     * Returns the total number of subscribers.
     * @return int total numbers.
     */
    public int getSize() {
        return subscribers.size();
    }
}
