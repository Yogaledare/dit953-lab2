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
}





//    private final Vector2D workshopLocation;
//    private final Vector2D entranceDirection;
//        this.workshopLocation = workshopLocation;
//        this.entranceDirection = gateDirection;

//    @Override
//    public int getSize() {
//        return storage.getSize();
//    }
//
//    public int getCapacity() {
//        return storage.getCapacity();
//    }






//    public Workshop() {
//        this(1, 2, 5, new Vector2D(50, 100));
//    }





//        try {
////            if (storageUnit.getCapacity() <= storageUnit.getSize())
////                throw new ArithmeticException("Tried to add car to storageUnit: capacity is " + storageUnit.getCapacity());
////
//        } catch (ArithmeticException ex) {
//            System.err.println("Workshop is full!");
//        }
