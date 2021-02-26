package Observer;

import java.util.List;

public interface EventObserver<T> {
    void actOnPublish(List<? extends T> loggable);
}
