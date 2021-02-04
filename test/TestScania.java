/*

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestScania {
    Scania truck;

    @Before
    public void setUp() {
        truck = new Scania();
    }

    @Test
    public void tryToDriveScaniaTruckWhenPlattformIsUp() {

        */
/*
         * Det är bara om lastbilen står stilla som flaket får ha en annan vinkel än 0.
         *
         * Flaket ska inte kunna höjas om lastbilen är i rörelse;
         * och lastbilen ska inte kunna köra om flaket är uppfällt.
         * *//*


        truck.raise(); // set ramp to 70 degree
        truck.startEngine();  // try start engine.
        truck.gas(1.0);
        truck.move();
        assertTrue(truck.getPosition().equals(new Vector2D(0, 0)));
    }

    @Test
    public void tryToRaisePlatformWhileDriving() {
        truck.lower();
        truck.startEngine();
        truck.gas(1.0);
        truck.move();

        truck.raise(); // try set ramp to 70.

        assertNotEquals(70, truck.getRampAngle(), 0.1);
     }
}
*/
