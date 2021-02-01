import java.io.IOException;

public class Workshop<T extends Storable> implements IStorageUnit<T> {

    private final LIFOStorageUnit<T> storageUnit;

    public Workshop(int capacity, double maxWidth, double maxLength) {
        storageUnit = new LIFOStorageUnit<>(capacity, maxWidth, maxLength);
    }

    public Workshop() {
        this(1, 2, 5);
    }


    @Override
    public void store(T item) {
        try {
            if (storageUnit.getCapacity() <= storageUnit.getSize())
                throw new ArithmeticException("Tried to add car to storageUnit: capacity is " + storageUnit.getCapacity());
            storageUnit.store(item);
        } catch (ArithmeticException ex) {
            System.err.println("Workshop is full!");
        }
    }

    @Override
    public T remove() {
        return storageUnit.remove();
    }

    public int getSize() {
        return storageUnit.getSize();
    }

    public int getCapacity() {
        return storageUnit.getCapacity();
    }

}
