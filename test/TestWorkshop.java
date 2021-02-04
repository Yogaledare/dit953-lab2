/*

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWorkshop {
    Workshop<Volvo240> bilia;
    Workshop<Vehicle> alisWorkshop;
    Volvo240 volvo240;
    Saab95 saab95;

    @Before
    public void setupWorkshops() {
        bilia = new Workshop<Volvo240>(20, 3, 6);
        volvo240 = new Volvo240();
        saab95 = new Saab95();
    }

    @Test
    public void addCartoWorkshop() {
        bilia.store(volvo240);
        assertEquals(1, bilia.getSize());
    }

    @Test
    public void overfillGarage() {
        final int CAPACITY = 10;
        alisWorkshop = new Workshop<>(CAPACITY, 3, 5);

        Vehicle pandas = new Saab95();
        for (int i = 0; i < alisWorkshop.getCapacity(); i++) {
            alisWorkshop.store(pandas);
        }
        alisWorkshop.store(pandas);
    }

    // Mr Ali can work on any kind of car.
    @Test
    public void addAndRemoveAnyCarToAlisWorkshop() {
        alisWorkshop = new Workshop<>(5, 3, 5);
        alisWorkshop.store(saab95);
        alisWorkshop.store(volvo240);
        Transportable returnCar;

        returnCar = alisWorkshop.remove();
        System.out.println(returnCar.getModelName());

        returnCar = alisWorkshop.remove();
        System.out.println(returnCar.getModelName());
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
        // TODO, var sätts width och length på en bil ?
    }
}
