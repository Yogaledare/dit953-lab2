import java.awt.*;

public class Ferry<T extends Storable> extends Vehicle implements Movable, IStorageUnit<T> {

    private final FIFO<T> storage;

    // private final Vehicles.Vehicle vehicle;

    public Ferry(){
        this.storage = new FIFO<T>(10, 1, 1);
    }

    public Ferry(FIFO<T> storageUnit) {
        this.storage = storageUnit;
    }

    @Override
    public void store(T item) {
        storage.add(item);
    }

    @Override
    public T remove() {
        return storage.remove();
    }

    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }
}


/*
    Skapa en representation av en bilfärja - dvs en färja på vilken det går att lasta bilar.

    Notera att bilfärjan inte är en bil (doh), men att många av de metoder vi hittills använt för olika sorters bilar bör gå att applicera även på färjan.
    Hur åstadkommer ni bäst detta?
    - implements Movable

    På bilfärjan gäller samma regler som för biltransporten,
    med undantaget att bilar lossas i samma ordning som de lastades,
    dvs den första bilen som lastades måste vara först att lossas (first-in-first-out).



Viktiga saker att ha i åtanke under den här uppgiften:

    Undvik kodduplicering för funktionalitet som är gemensam för e.g. bilfärjan och biltransporten.
    Fundera över behovet av polymorfism - nuvarande och ev. framtida.


 */