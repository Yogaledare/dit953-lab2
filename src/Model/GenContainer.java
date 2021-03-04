package Model;

import java.util.ArrayDeque;
import java.util.Deque;
import javafx.util.*;

import javax.crypto.spec.DESedeKeySpec;

public class GenContainer<T extends ITransportable> implements ITransporter<T>, ITransportable {

    private final int capacity;
    private final double maxWidth;
    private final double maxLength;
    protected final double pickUpRange;
    private final Vector2D position;
    protected final Vector2D direction;
    protected final Deque<T> holder;
    protected final double length;
    protected final double width;

    public GenContainer(int capacity, double maxWidth, double maxLength, double pickUpRange,
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
    public GenContainer(int capacity, double maxWidth, double maxLength, double pickUpRange,
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


    public ITransporter<T> store(T item) {
        Deque<T> newHolder = new ArrayDeque<>(holder);
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
        newHolder.addLast(item);
        item.follow(this);
        return new GenContainer<T>(capacity, maxWidth, maxLength, pickUpRange, position, direction, length, width, newHolder);
    }

    @Override
    public Pair<T, ITransporter<T>> remove(RemovingMethod removingMethod) {
        Deque<T> newHolder = new ArrayDeque<>(holder);
        T removedItem = removingMethod.apply(newHolder);
        GenContainer<T> newGenContainer = new GenContainer<T>(capacity, maxWidth, maxLength, pickUpRange, position, direction, length, width, newHolder);
        return new Pair<>(removedItem, newGenContainer);
    }



    @Override
    public int getSize() {
        return holder.size();
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
        return width;
    }

    @Override
    public double getLength() {
        return length;
    }

    //    @Override
//    public <T extends ITransportable> T follow(ITransporter<T> transporter) {

    public <K extends ITransportable> ITransportable follow(ITransporter<K> transporter) {
        Vector2D newPosition = transporter.getPosition();


        for (ITransportable item : holder) {
            item.follow(transporter);
        }




        return new GenContainer<T>(
                capacity, maxWidth, maxLength, pickUpRange, newPosition, direction, length, width, holder);
    }
}
