import java.util.Vector;

/**
 * An implemented class representing a cargo hold
 * using last in first out rules
 *
 * @param <T> The type stored in the container
 */
public class LIFO<T extends Transportable> extends Container<T> {

    public LIFO(int capacity, double maxWidth, double maxLength, double pickUpRange, Vector2D position, Vector2D direction, double length) {
        super(capacity, maxWidth, maxLength, pickUpRange, position, direction, length);
    }

    /**
     * Returns the item to be removed
     * @return the item to be removed
     */
    protected T findItemToRemove() {
        return holder.removeLast();
    }

    /**
     * Find where to place the removed thing
     * @return where to place the removed thing
     */
    protected Vector2D findOffset() {
        return direction.multiplyByScalar(-(length / 2 + pickUpRange / 2));
    }
}
