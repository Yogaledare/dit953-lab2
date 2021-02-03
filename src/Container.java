import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An abstract class representing a cargo hold
 * @param <T> The type stored in the container
 */
public abstract class Container<T extends Storable> {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    protected final Deque<T> storage;

    public abstract T remove();

    /**
     *
     * @param capacity The maximum capacity
     * @param maxWidth The maximum width of items stored
     * @param maxLength The maximum length of items stored
     */
    public Container(int capacity, double maxWidth, double maxLength) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.storage = new ArrayDeque<>(capacity);
    }

    public void move(Vehicle vehicle){

        for (T stored : storage) {
            stored.follow(this);
            stored.setPosition(vehicle.getPosition());
            stored.setDirection(vehicle.getDirection());
        }
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

    public void add(T item) {
        if(item.getWidth() <= getMaxWidth() && item.getLength() <= getMaxLength())
            storage.addLast(item);
    }

    public int getSize() {
        return storage.size();
    }
}
