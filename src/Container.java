import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An abstract class representing a cargo hold
 * @param <T> The type stored in the container
 */
public abstract class Container<T extends Transportable> implements IStorageUnit<T>{
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
    public Container(int capacity, double maxWidth, double maxLength, double pickUpRange, Vector2D position, Vector2D direction, double length) {
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

    //@Override
    public T remove(/*Vector2D offset*/) {
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
    }

    protected abstract T findItemToRemove();

    protected abstract Vector2D findOffset();

    public int getSize(){
        return holder.size();
    }

}


//    public abstract T remove();


//    public abstract T remove(Vector2D offset);


/*    public double getMaxWidth() {
        return maxWidth;
    }

    public double getMaxLength() {
        return maxLength;
    }*/

/*    public int getCapacity() {
        return capacity;
    }*/

/*    public int getSize() {
        return holder.size();
    }*/


/*    @Override
    public double getPickUpRange() {
        return pickUpRange;
    }*/
/*
    @Override
    public void moveCargo(Vector2D newPosition) {
        for (T item : holder) {
            item.setPosition(newPosition);
        }
    }
*/


//    public void move(Vehicle vehicle){
//
//        for (T stored : storage) {
//            stored.follow(this);
//            stored.setPosition(vehicle.getPosition());
//            stored.setDirection(vehicle.getDirection());
//        }
//    }

//    public Deque<T> getHolder() {
//        return holder;
//    }

//    public void add(T item) {
//        if(item.getWidth() <= getMaxWidth() && item.getLength() <= getMaxLength())
//            holder.addLast(item);
//    }
