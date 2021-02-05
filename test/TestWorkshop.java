import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWorkshop {
    Workshop<Volvo240> bilia;
    Workshop<Transportable> alisWorkshop;
    Volvo240 volvo240;
    Saab95 saab95;
    Vector2D location;
    Vector2D entranceDirection;
    @Before
    public void setupWorkshops() {
        location = new Vector2D(4,4);
        entranceDirection = new Vector2D(1,0);
        bilia = new Workshop<Volvo240>(20, 3, 6, location, entranceDirection);

        volvo240 = new Volvo240(2,5);
        saab95 = new Saab95(2,5);
    }



    @Test
    public void addCartoWorkshop() {
        bilia.store(volvo240);

//         bilia.store(saab95); // Ger statiskt fel

        assertEquals(1, bilia.getSize());
    }

    @Test(expected = IllegalStateException.class )
    public void overfillGarage() {
        final int CAPACITY = 10;
        alisWorkshop = new Workshop<>(CAPACITY, 3, 5, location, entranceDirection);

        for (int i = 0; i < alisWorkshop.getCapacity(); i++) {
            alisWorkshop.store(saab95);
        }
        alisWorkshop.store(saab95);
        System.err.println("Garage is full, come back later!");
    }

    // Mr Ali can work on any kind of car.
    @Test
    public void addAndRemoveAnyCarToAlisWorkshop() {
        alisWorkshop = new Workshop<>(5, 3, 5, location, entranceDirection);
        alisWorkshop.store(saab95);
        alisWorkshop.store(volvo240);
        Transportable returnCar;

        returnCar = alisWorkshop.remove();
        // System.out.println(returnCar.getModelName());

        returnCar = alisWorkshop.remove();
        // System.out.println(returnCar.getModelName());
        assertEquals(0, alisWorkshop.getSize());
    }

    @Test
    public void removeCarFromWorkshop() {
        bilia.store(volvo240);
        bilia.remove();
        assertEquals(0, bilia.getSize());
    }

    @Test(expected = IllegalArgumentException.class )
    public void addOversizeCar() {
        Volvo240 bigvolvo = new Volvo240(5,10);
        bilia.store(bigvolvo);
    }
}
