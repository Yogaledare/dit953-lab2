/**
 * An implemented class representing a cargo hold
 * using the first in first out rules
 * @param <T> The type stored in the container
 */
public class FIFO<T extends Storable> extends Container<T> {

    public FIFO(int capacity, double maxWidth, double maxLength) {
        super(capacity, maxWidth, maxLength);
    }

    @Override
    public T remove() {
        return storage.removeFirst();
    }
}
