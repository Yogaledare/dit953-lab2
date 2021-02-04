/**
 * An implemented class representing a cargo hold
 * using the first in first out rules
 * @param <T> The type stored in the container
 */
public class FIFO<T extends Transportable> extends Container<T> {

    public FIFO(int capacity, double maxWidth, double maxLength, double pickUpRange, Vector2D position, Vector2D direction, double length) {
        super(capacity, maxWidth, maxLength, pickUpRange, position, direction, length);
    }

    protected T findItemToRemove() {
        return holder.removeFirst();
    }

    protected Vector2D findOffset() {
        return direction.multiplyByScalar((length / 2 + pickUpRange / 2));
    }

}



//    @Override
//    public T remove(Vector2D offset) {
//        T item = storage.removeFirst();
//        Vector2D unloadedPosition = item.getPosition().plus(offset);
//        item.setPosition(unloadedPosition);
//        return item;
//    }




//        Vector2D offset = car.getDirection().multiplyByScalar(-5);
