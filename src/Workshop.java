import java.io.IOException;

public class Workshop<T extends Storable> implements IStorageUnit<T> {

    private final LIFOStorageUnit<T> storageUnit;

    public Workshop(int capacity, double maxWidth, double maxHeight) {
        storageUnit = new LIFOStorageUnit<>(capacity, maxWidth, maxHeight);
    }

    public Workshop() {
        this(20, 2.3, 1.6);
    }


    @Override
    public void store(T item) {
        try {
            if (storageUnit.getCapacity() <= storageUnit.getSize()) throw new ArithmeticException("Tried to add car to storageUnit: capacity is " + storageUnit.getCapacity());
            storageUnit.store(item);
        } catch (ArithmeticException ex) {
            System.out.println("Workshop is full!");
        }
    }

    @Override
    public T remove() {
        return storageUnit.remove();
    }

    public int getSize() {
        return storageUnit.getSize();
    }

}
