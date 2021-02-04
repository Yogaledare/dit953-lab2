public interface IStorageUnit<T extends Transportable> {

    void store(T item/*, Vector2D storagePosition*/);
    T remove(/*Vector2D offset*/);
//    void moveCargo(/*Vector2D newPosition*/);
//    double getPickUpRange();
    void relocate(Vector2D position, Vector2D direction);
}
