

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class TestScania {
    Scania truck;

    @Before
    public void setUp() {
        truck = new Scania(2, 6/*, "Scania lastbil", Color.black, 2*/);
    }


    @Test
    public void driveScaniaAndRaise() {
        truck.lower(70);
        truck.startEngine();
        truck.gas(1.0);
        truck.move();
        truck.raise(70);
        assertFalse(truck.isFullyRaised());
    }

    @Test
    public void tryToDriveScaniaTruckWhenPlattformIsUp() {

         /*
           Det är bara om lastbilen står stilla som flaket får ha en annan vinkel än 0.
           Flaket ska inte kunna höjas om lastbilen är i rörelse;
           och lastbilen ska inte kunna köra om flaket är uppfällt.
         */

        truck.setPosition(new Vector2D(1, 1));
        truck.raise(70); // set ramp to 70 degree
        truck.startEngine();  // try start engine.
        truck.gas(1.0);
        truck.move();
        assertTrue(truck.getPosition().equals(new Vector2D(1, 1)));
    }

    @Test
    public void tryToRaisePlatformWhileDriving() {
        truck.lower(70);
        truck.startEngine();
        truck.gas(1.0);
        truck.move();
        truck.raise(70); // try set ramp to 70.
        assertFalse(truck.isFullyRaised());
     }
}

