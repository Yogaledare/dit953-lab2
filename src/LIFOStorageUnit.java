import java.util.Deque;

public class LIFOStorageUnit<T extends Storable> implements IStorageUnit<T> {
    private final int capacity;
    private final double maxWidth;
    private final double maxHeight;
    private Deque<T> storage;

    public LIFOStorageUnit(int capacity, double maxWidth, double maxHeight) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public void store(T item) {
        storage.addLast(item);
    }

    public T remove() {
        return storage.removeLast();
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public int getCapacity() {
        return capacity;
    }
}
