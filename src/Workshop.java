public class Workshop<T extends Transportable> /*implements IStorageUnit<T>*/ {

    private final LIFO<T> storage;

    public Workshop(int capacity, double maxWidth, double maxLength, Vector2D workshopLocation, Vector2D entranceDirection) {
        storage = new LIFO<>(capacity, maxWidth, maxLength, 2, workshopLocation, entranceDirection, 10);

    }

    public void store(T item) {
        storage.store(item);
    }

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
