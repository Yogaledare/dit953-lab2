public class Workshop<T extends Storable> implements IStorageUnit<T> {

    private final LIFOStorageUnit<T> storageUnit;

    public Workshop(int capacity, double maxWidth, double maxHeight){
        storageUnit = new LIFOStorageUnit<>(capacity, maxWidth, maxHeight);
    }

    public Workshop() {
        this(20, 2.3, 1.6);
    }


    @Override
    public void store(T item) {
        storageUnit.store(item);
    }

    @Override
    public T remove() {
        return storageUnit.remove();
    }

    // public double getMaxWidth() {
    //    return storageUnit.getMaxWidth();
    // }

    // public double getMaxLength() {
    //    return storageUnit.getMaxLength();
    //}

    public int getSize() {
        return storageUnit.getSize();
    }

}
