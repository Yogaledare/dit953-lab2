import java.util.List;
import java.util.ArrayList;

public class ObserverHandler {
    private List<PaintObserver> subscribers = new ArrayList<>();

    public void addSubscriber(PaintObserver observer){
        subscribers.add(observer);
    }

    public void removeSubscriber(PaintObserver observer){
        subscribers.remove(observer);
    }

    public void publish(List<? extends IPaintable> paintables){
        for (PaintObserver observer : subscribers) {
            observer.actOnPublish(paintables);
        }
    }
}
