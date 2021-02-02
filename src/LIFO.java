/**
 * An implemented class representing a cargo hold
 * using last in first out rules
 * @param <T> The type stored in the container
 */
public class LIFO<T extends Storable> extends Container<T> {

    public LIFO(int capacity, double maxWidth, double maxLength) {
        super(capacity, maxWidth, maxLength);
    }

    @Override
    public T remove() {
        return storage.removeLast();
    }
}
