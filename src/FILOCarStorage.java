import java.util.*;

public class FILOCarStorage implements ICarStorage {
    private final int capacity;
    private final double maxHeight;
    private final double maxWidth;
    private Deque<Car> storedCars;

    public FILOCarStorage(int capacity, double maxHeight, double maxWidth) {
        this.capacity = capacity;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.storedCars = new ArrayDeque<>();
    }

    public void addCar(Car car) {
        storedCars.addLast(car);
    }

    public Car removeCar() {
        return storedCars.removeLast();
    }

    public Deque<Car> getStoredCars() {
        return storedCars;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    @Override
    public String toString() {
        return "(" + capacity + ", "+ storedCars + ")";
    }
}
