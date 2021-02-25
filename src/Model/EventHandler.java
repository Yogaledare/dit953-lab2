package Model;

        import java.util.List;
        import java.util.ArrayList;

public class EventHandler<T extends EventObserver, I > {
    private List<T> subscribers = new ArrayList<>();

    public void addSubscriber(T observer){
        subscribers.add(observer);
    }

    public void removeSubscriber(T observer){
        subscribers.remove(observer);
    }

    public void publish(List<? extends I> publisher){
        for (T observer : subscribers) {
            observer.actOnPublish(publisher);
        }
    }

    public int getSize() {
        return subscribers.size();
    }
}
