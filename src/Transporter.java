/**
 * Transporter interface enables an object to act as a transporter.
 * @param <T>
 */
public interface Transporter<T extends Transportable> {
    void store(T item);
    T remove();
    int getSize();
}
