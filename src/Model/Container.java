package Model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An abstract class representing a cargo hold
 *
 * @param <T> The type stored in the container, LIFO or FIFO
 */
public abstract class Container<T extends ITransportable> implements ITransporter<T> {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    protected final double pickUpRange;
    private Vector2D position;
    protected Vector2D direction;
    protected Deque<T> holder;
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
        item = (T) item.getCarriedTo(position, direction);
        holder.addLast(item);
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
        item = (T) item.getCarriedTo(unloadedPosition, direction);
        return item;
    }



    public <K extends ITransportable> void carryElements(ITransporter<K> iTransporter) {
        this.position = iTransporter.getPosition();
        this.direction = iTransporter.getDirection();

        Deque<T> newDeque = new ArrayDeque<>();

        while (!holder.isEmpty()) {
            T item = holder.removeLast();
            item = (T) item.follow(iTransporter);
            newDeque.add(item);
        }
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxLength() {
        return maxLength;
    }

    public double getPickUpRange() {
        return pickUpRange;
    }

    public double getLength() {
        return length;
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

    @Override
    public Vector2D getPosition() {
        return new Vector2D(position);
    }

    @Override
    public Vector2D getDirection() {
        return new Vector2D(direction);
    }

    /**
     * Amount of object the holder can store.
     * @return the total capacity.
     */
    public int getCapacity() {
        return capacity;
    }

}



/*
    public Container(Container container) {
        this.capacity = container.capacity;
        this.maxWidth = container.maxWidth;
        this.maxLength = container.maxLength;
        this.pickUpRange = container.pickUpRange;
        this.position = container.position;
        this.direction = container.direction;
        this.length = container.length;
        this.holder = container.holder;
    }
*/




/**
 * relocate updates stored items vectors.
 * @param position the current positions of the holder parent.
 * @param direction the current orientataion of the holder parent
 */
/*    public void relocate(Vector2D position, Vector2D direction) {
        this.position = position;
        this.direction = direction;
        for (ITransportable item : holder) {
            item.setPosition(position);
            item.setDirection(direction);
        }
    }*/


        /*
        Deque<ITransportable> newDeque = new ArrayDeque<>();
        while (!temp.isEmpty()) {
            ITransportable item = temp.removeLast();
            item = item.follow(transporter);
            newDeque.add(item);
        }



        for (T item : holder) {
            getCarried(position, direction);
        }*/

