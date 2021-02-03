/**
 * An implemented class representing a cargo hold
 * using the first in first out rules
 * @param <T> The type stored in the container
 */
public class FIFO<T extends Transportable> extends Container<T> {

    public FIFO(int capacity, double maxWidth, double maxLength) {
        super(capacity, maxWidth, maxLength);
    }

    @Override
    public T remove() {
        T car = storage.removeFirst();
        Vector2D offset = car.getDirection().multiplyByScalar(-5);
        Vector2D unloadedPosition = car.getPosition().plus(offset);
        car.setPosition(unloadedPosition);
        return car;
    }
}
