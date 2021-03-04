package Model;

import javafx.util.*;
/**
 * Transporter interface enables an object to act as a transporter.
 * @param <T> things to transport
 */
public interface ITransporter<T extends ITransportable> {

    ITransporter<T> store(T item);
    Pair<T, ITransporter<T>> remove(RemovingMethod removingMethod);
    int getSize();
    Vector2D getPosition();
    Vector2D getDirection();
}
