import java.util.ArrayDeque;
import java.util.Deque;

public class Container<T extends Storable> {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    private final Deque<T> storage;

    public Container(int capacity, double maxWidth, double maxLength) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.storage = new ArrayDeque<>();
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxLength() {
        return maxLength;
    }

    public int getCapacity() {
        return capacity;
    }

    public Deque<T> getStorage() {
        return storage;
    }

    public void addLast(T item) {
        storage.addLast(item);
    }

    public T removeFirst() {
        return storage.removeFirst();
    }

    public T removeLast() {
        return storage.removeLast();
    }

    public int getSize() {
        return storage.size();
    }
}
