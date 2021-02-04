/**
 * Stationary place to store and repair things
 * @param <T> the type of the things to repair
 */
public class Workshop<T extends Transportable> /*implements IStorageUnit<T>*/ {

    /**
     * Storage component
     */
    private final LIFO<T> storage;

    /**
     * Creates a workshop for repairing a certain type T
     * @param capacity How many things can be stored at once
     * @param maxWidth Max width of things stored
     * @param maxLength Max length of things stored
     * @param workshopLocation The workshops location
     * @param entranceDirection Where is the garage door pointing
     */
    public Workshop(int capacity, double maxWidth, double maxLength, Vector2D workshopLocation, Vector2D entranceDirection) {
        storage = new LIFO<>(capacity, maxWidth, maxLength, 2, workshopLocation, entranceDirection, 10);
    }

    /**
     * Store an item to be repaired
     * @param item thing to be stored
     */
    public void store(T item) {
        storage.store(item);
    }

    /**
     * Remove an item that's done
     * @return the repaired thing
     */
    public T remove() {
        return storage.remove();
    }

    /**
     * Current number of things to be repaired
     * @return number of things in storage
     */
    public int getSize() {
        return storage.getSize();
    }

    /**
     * Max number of things that can be stored
     * @return max number of things that can be stored at once
     */
    public int getCapacity() {
        return storage.getCapacity();
    }

}
