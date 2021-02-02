import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;

public class BufferStorageUnit<T extends Storable> implements IStorageUnit<T>{

    List<T> inProcess;
    List<T> waitingForPickup;
//    Deque<Customer<T>> customers;

    public BufferStorageUnit(int capacity){
        inProcess = new ArrayList<T>(capacity);
        waitingForPickup = new ArrayList<T>(capacity);
//        customers = new ArrayDeque<Customer<T>>();
    }

    private void moveToBuffer(T item) {
        if (inProcess.remove(item)) {
            waitingForPickup.add(item);
        }
    }


    @Override
    public void store(T item) {

    }

    @Override
    public T remove() {
        return null;
    }

    public T remove(T item) {
        waitingForPickup.remove(item);
        // Customer<T> servedCustomer = customers.getFirst();
        // T item = servedCustomer.getOwnedItem();
        // waitingForPickup.remove(item);
        // customers.remove(servedCustomer);
        // return waitingForPickup;
        return item;
    }


    // public double getMaxWidth() {
    //    return 0;
    // }

    // public double getMaxLength() {
    //    return 0;
    //}



    public boolean add(T t){
        return inProcess.add(t);
    }

}
/*
class Customer<T> {

    private T ownedItem;

    public T getOwnedItem() {
        return ownedItem;
    }

}
*/


/*

    1) En verkstad ska kunna ta emot ("lasta"?) ett antal bilar, upp till något max-antal som kan variera mellan olika verkstäder.
    2) Vissa verkstäder ska bara kunna ta emot en viss sorts bilar; andra kan ta emot vilka bilar som helst.
    3) Att försöka lämna in "fel" sorts bil i en verkstad ska ge ett statiskt (compile time) fel.
    4) Vid uthämtning av en bil från verkstaden ska vi kunna få så precis typinformation som möjligt statiskt.
        Exempel: För en märkesverkstad som enbart hanterar Volvo 240 bör vi statiskt kunna veta att bilar som hämtas ut från verkstaden alltid är just Volvo 240.


 */