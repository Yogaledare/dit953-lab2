import java.util.Deque;

public class FIFOStorageUnit<T extends Storable> implements IStorageUnit {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    private Deque<T> storage;

    public FIFOStorageUnit(int capacity, double maxWidth, double maxLength) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
    }

    @Override
    public void store(T item) {
        storage.addLast(item);
    }

    @Override
    public T remove() {
        return storage.removeFirst();
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    @Override
    public double getMaxLength() {
        return maxLength;
    }

}




