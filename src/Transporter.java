/**
 * Transporter interface enables an object to act as a transporter.
 * @param <T>
 */
public interface Transporter<T extends Transportable> {
    void store(T item/*, Vector2D storagePosition*/);
    T remove(/*Vector2D offset*/);
//    void moveCargo(/*Vector2D newPosition*/);
//    double getPickUpRange();
    //void relocate(Vector2D position, Vector2D direction);
    int getSize();
}
