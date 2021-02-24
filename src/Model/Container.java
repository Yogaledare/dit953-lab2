package Model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An abstract class representing a cargo hold
 *
 * @param <T> The type stored in the container
 */
public abstract class Container<T extends Transportable> /*implements Model.Model.Transporter<T>*/ {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    protected final double pickUpRange;
    private Vector2D position;
    protected Vector2D direction;
    protected final Deque<T> holder;
    protected double length;

    /**
     * @param capacity  The maximum capacity
     * @param maxWidth  The maximum width of items stored
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

    /**
     * Store an item into holder.
     * @param item is the item to be stored.
     */
    public void store(T item) {
        if (holder.size() >= capacity) {
            throw new IllegalStateException("Model.Model.Container full");
        }
        if (item.getLength() > maxLength) {
            throw new IllegalArgumentException("Item too long");
        }
        if (item.getWidth() > maxWidth) {
            throw new IllegalArgumentException("Item too wide");
        }
        if (item.getPosition().distanceTo(position) > (length / 2) + pickUpRange) {
            throw new IllegalArgumentException("Item too far away");
        }
        holder.addLast(item);
        item.setPosition(position);
    }

    /**
     * Eject the item stored in holder.
     * current item is decided by findItemToRemove(), which depends on if it's Model.Model.LIFO or Model.Model.FIFO.
     * @return gives a item stored in holder.
     */
    public T remove() {
        T item = findItemToRemove();
        Vector2D offset = findOffset();
        Vector2D unloadedPosition = item.getPosition().plus(offset);
        item.setPosition(unloadedPosition);
        return item;
    }

    /**
     * relocate updates stored items vectors.
     * @param position the current positions of the holder parent.
     * @param direction the current orientataion of the holder parent
     */
    public void relocate(Vector2D position, Vector2D direction) {
        this.position = position;
        this.direction = direction;
        for (Transportable item : holder) {
            item.setPosition(position);
            item.setDirection(direction);
        }
    }

    /**
     * FindItemToRemove finds which object to remove, depending on Model.Model.LIFO or Model.Model.FIFO
     * @return type of container class.
     */
    protected abstract T findItemToRemove();

    /**
     * findOffset to decide if the "direction" T should be Model.Model.FIFO or Model.Model.LIFO.
     * @return type of container class
     */
    protected abstract Vector2D findOffset();

    /**
     * Amount of objects in holder.
     * @return the number of objects
     */
    public int getSize() {
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


