package Observer;

import java.util.Collection;
import java.util.List;

public interface EventObserver<T> {
    void actOnPublish(Collection</*? extends */T> loggable);
}
