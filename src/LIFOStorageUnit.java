import java.util.Deque;

public class LIFOStorageUnit implements IStorageUnit {
    private final int capacity;
    private final double maxWidth;
    private final double maxHeight;
    private Deque<Storable> storage;

    public LIFOStorageUnit(int capacity, double maxWidth, double maxHeight) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public <T extends Storable> void store(T item) {
        storage.addLast(item);
    }

    public Storable remove() {
        return storage.removeLast();
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxHeight() {
        return maxHeight;
    }
}
