import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An abstract class representing a cargo hold
 * @param <T> The type stored in the container
 */
public abstract class Container<T extends Transportable> /*implements Transporter<T>*/ {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    protected final double pickUpRange;
    private Vector2D position;
    protected Vector2D direction;
    protected final Deque<T> holder;
    protected double length;

    /**
     *
     * @param capacity The maximum capacity
     * @param maxWidth The maximum width of items stored
     * @param maxLength The maximum length of items stored
     */
    public Container(int capacity, double maxWidth, double maxLength, double pickUpRange,
                     Vector2D position, Vector2D direction, double length) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.pickUpRange = pickUpRange;
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.holder = new ArrayDeque<>(capacity);
    }

    //@Override
    public void store(T item/*, Vector2D storagePosition*/) {
        if (holder.size() >= capacity) {
            throw new IllegalStateException("Container full");
        }
        if (item.getLength() > maxLength) {
            throw new IllegalArgumentException("Item too long");
        }
        if (item.getWidth() > maxWidth) {
            throw new IllegalArgumentException("Item too wide");
        }
        if (item.getPosition().distanceTo(position) > length / 2 + pickUpRange) {
            throw new IllegalArgumentException("Item too far away");
        }
        holder.addLast(item);
        item.setPosition(position);
    }

    /**
     * Eject the item stored in holder.
     * current item is decided by findItemToRemove(), which depends on if it's LIFO or FIFO.
     * @return gives a item stored in holder.
     */
    public T remove() {
        T item = findItemToRemove();
        Vector2D offset = findOffset();
        Vector2D unloadedPosition = item.getPosition().plus(offset);
        item.setPosition(unloadedPosition);
        return item;
    }

    //@Override
    public void relocate(Vector2D position, Vector2D direction) {
        this.position = position;
        this.direction = direction;
        for (Transportable item : holder) {
            item.setPosition(position);
            item.setDirection(direction);
        }
    }

    protected abstract T findItemToRemove();

    protected abstract Vector2D findOffset();

    public int getSize(){
        return holder.size();
    }

    /**
     * Amount of object the holder can store.
     * @return the total capacity.
     */
    public int getCapacity() {
        return capacity;
    }

}


