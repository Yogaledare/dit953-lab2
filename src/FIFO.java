public class FIFO<T extends Storable> extends Container<T> {

    public FIFO(int capacity, double maxWidth, double maxLength) {
        super(capacity, maxWidth, maxLength);
    }

    @Override
    public T remove() {
        return storage.removeFirst();
    }
}
