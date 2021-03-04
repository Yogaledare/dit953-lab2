package Model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An abstract class representing a cargo hold
 *
 * @param <T> The type stored in the container, LIFO or FIFO
 */
public abstract class Container<T extends ITransportable> implements ITransporter<T>, ITransportable {
    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    protected final double pickUpRange;
    private final Vector2D position;
    protected final Vector2D direction;
    protected final Deque<T> holder;
    protected final double length;
    protected final double width;



    public Container(int capacity, double maxWidth, double maxLength, double pickUpRange,
                     Vector2D position, Vector2D direction, double length, double width, Deque<T> holder) {
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.pickUpRange = pickUpRange;
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.holder = holder;
    }

    /**
     * @param capacity  The maximum capacity
     * @param maxWidth  The maximum width of items stored
     * @param maxLength The maximum length of items stored
     */
    public Container(int capacity, double maxWidth, double maxLength, double pickUpRange,
                     Vector2D position, Vector2D direction, double length, double width) {

        this(capacity, maxWidth, maxLength, pickUpRange, position, direction, length, width, new ArrayDeque<>(capacity));
        /*
        this.capacity = capacity;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
        this.pickUpRange = pickUpRange;
        this.position = position;
        this.direction = direction;
        this.length = length;
        this.width = width;
        this.holder = new ArrayDeque<>(capacity);*/
    }




    /**
     * Store an item into holder.
     * @param item is the item to be stored.
     */
    public void store(T item) {
        Deque<T> newDeque = new ArrayDeque<>(holder);
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
        newDeque.addLast(item);
        item.follow(this);
//        return new Container<T>(capacity, maxWidth, maxLength, pickUpRange, position, direction, length, width, newDeque);
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
        // vill vi verkligen ha follow på ett item som skall "ejectas" ?
        // item.follow(this);

        return item;
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




    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public Vector2D getDirection() {
        return direction;
    }



    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getLength() {
        return 0;
    }

    @Override
    public <T extends ITransportable> T follow(ITransporter<T> transporter) {
        return null;
    }
}


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
    public void getCarried(Vector2D position, Vector2D direction) {
        this.position = position;
        this.direction = direction;
        for (ITransportable item : holder) {
            getCarried(position, direction);
        }
    }
*/




