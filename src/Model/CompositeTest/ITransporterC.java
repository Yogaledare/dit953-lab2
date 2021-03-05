package Model.CompositeTest;

import Model.ITransportable;
import Model.RemovingMethod;
import Model.Vector2D;
// import javafx.util.*;

/**
 * Transporter interface enables an object to act as a transporter.
 * @param <T> things to transport
 */
public interface ITransporterC<T extends ITransportable> {

    Model.ITransporter<T> store(T item);
//    Pair<T, Model.ITransporter<T>> remove(RemovingMethod removingMethod);
    int getSize();
    Vector2D getPosition();
    Vector2D getDirection();
}
