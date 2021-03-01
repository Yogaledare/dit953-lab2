package Model;

/**
 * An implemented class representing a cargo hold
 * using the first in first out rules
 * @param <T> The type stored in the container
 */
public class FIFO<T extends ITransportable> extends Container<T> {

    public FIFO(int capacity, double maxWidth, double maxLength, double pickUpRange, Vector2D position, Vector2D direction, double length) {
        super(capacity, maxWidth, maxLength, pickUpRange, position, direction, length);
    }

    /**
     * Returns the item to be removed
     * @return the item to be removed
     */
    protected T findItemToRemove() {
        return holder.removeFirst();
    }

    /**
     * Find where to place the removed thing
     * @return where to place the removed thing
     */
    protected Vector2D findOffset() {
        return direction.multiplyByScalar((length / 2 + pickUpRange / 2));
    }

}