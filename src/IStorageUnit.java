public interface IStorageUnit<T extends Storable> {

    void store(T item);
    T remove();
    // double getMaxWidth();
    // double getMaxLength();


}
