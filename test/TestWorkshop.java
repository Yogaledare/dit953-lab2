import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWorkshop {
    Workshop<Volvo240> bilia;
    Workshop<Car> alisWorkshop;

    @Before
    public void setupWorkshops() {
        bilia = new Workshop<Volvo240>(20, 3, 6);
    }

    @Test
    public void addCartoWorkshop() {

        Volvo240 volvo240 = new Volvo240();

        bilia.store(volvo240);

        assertEquals(1, bilia.getSize());
    }

    @Test
    public void overfillGarage() {
        final int CAPACITY = 10;
        alisWorkshop = new Workshop<>(CAPACITY, 3, 5);

        Car pandas = new KiaNokia();
        for (int i = 0; i < CAPACITY; i++) {
            alisWorkshop.store(pandas);
        }

        alisWorkshop.store(pandas);


    }
    @Test
    public void removeCarFromWorkshop() {

    }

}
