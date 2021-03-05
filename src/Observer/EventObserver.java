package Observer;

import java.util.Collection;

public interface EventObserver<T> {
    void actOnPublish(Collection<? extends T> loggable);
}
