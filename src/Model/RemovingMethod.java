package Model;
import java.util.Deque;

@FunctionalInterface
public interface RemovingMethod {
    public <T extends ITransportable> T apply(Deque<T> deque);
}

