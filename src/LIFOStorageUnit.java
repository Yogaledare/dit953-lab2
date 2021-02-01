import java.util.Deque;

public class LIFOStorageUnit<T extends Storable> implements IStorageUnit<T> {
    private final Container<T> storage;

    public LIFOStorageUnit(int capacity, double maxWidth, double maxLength) {
        this.storage = new Container<T>(capacity, maxWidth, maxLength);
    }

    public void store(T item) {
        storage.addLast(item);
    }

    @Override
    public T remove() {
        return storage.removeLast();
    }


    public int getCapacity() {
        return storage.getCapacity();
    }

    public Deque<T> getStorage() {
        return storage.getStorage();
    }

    public int getSize() {
        return storage.getSize();
    }
}


/*    private final int capacity;
    private final double maxWidth;
    private final double maxHeight;
    private Deque<T> storage;*/

/*    public LIFOStorageUnit(int capacity, double maxWidth, double maxHeight) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }*/
