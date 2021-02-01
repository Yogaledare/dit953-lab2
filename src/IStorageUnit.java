public interface IStorageUnit {

    <T extends Storable> void store(T item);
    Storable remove();
    double getMaxWidth();
    double getMaxHeight();

}
