import java.util.Collection;

public class Ferry<T extends Storable> implements Movable, IStorageUnit<T> {

    private final FIFOStorageUnit<T> storageUnit;

    public Ferry(FIFOStorageUnit<T> storageUnit) {
        this.storageUnit = storageUnit;
    }



    @Override
    public void store(T item) {
        storageUnit.store(item);
    }

    @Override
    public T remove() {
        return storageUnit.remove();
    }

    // public double getMaxWidth() {
    //     return 0;
    // }

    // public double getMaxLength() {
    //    return 0;
    // }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

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