import java.util.Deque;

public class FIFOStorageUnit implements IStorageUnit {
    private final int capacity;
    private final double maxWidth;
    private final double maxHeight;
    private Deque<Storable> storage;

    public FIFOStorageUnit(int capacity, double maxWidth, double maxHeight) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public <T extends Storable> void store(T item) {
        storage.addLast(item);
    }

    public Storable remove() {
        return storage.removeFirst();
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxHeight() {
        return maxHeight;
    }



}
