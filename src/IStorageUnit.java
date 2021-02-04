public interface IStorageUnit<T extends Storable> {

    void store(T item);
    T remove(Vector2D offset);
    void moveCargo(Vector2D newPosition);

}
