import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWorkshop {
    Workshop<Volvo240> bilia = new Workshop<Volvo240>(20, 3, 6);

    @Test
    public void addCartoWorkshop() {
        Car volvo = new Volvo240();

        Volvo240 volvo240 = new Volvo240();

        bilia.store(volvo240);

        assertEquals(1, bilia.getSize());
    }

    @Test
    public void removeCarFromWorkshop() {

    }

}
