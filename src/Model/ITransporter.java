package Model;

/**
 * Model.Model.Transporter interface enables an object to act as a transporter.
 * @param <T> things to transport
 */
public interface ITransporter<T extends ITransportable> {
    void store(T item);
    T remove();
    int getSize();
}
