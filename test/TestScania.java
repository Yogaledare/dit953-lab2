//
//
//import org.junit.Before;
//import org.junit.Test;
//import Model.*;
//
//
//import static org.junit.Assert.*;
//
//
//public class TestScania {
//    IRampVehicle truck;
//
//    @Before
//    public void setUp() {
//        truck = CarFactory.createScania(new Vector2D(0, 0));
//    }
//
//
//    @Test
//    public void driveScaniaAndRaise() {
//        truck.lower(70);
//        truck.startEngine();
//        truck.gas(1.0);
//        truck.move();
//        truck.raise(70);
//        assertFalse(truck.isFullyRaised());
//    }
//
//    @Test
//    public void tryToDriveScaniaTruckWhenPlattformIsUp() {
//
//         /*
//           Det är bara om lastbilen står stilla som flaket får ha en annan vinkel än 0.
//           Flaket ska inte kunna höjas om lastbilen är i rörelse;
//           och lastbilen ska inte kunna köra om flaket är uppfällt.
//         */
//
//        truck.raise(70); // set ramp to 70 degree
//        truck.startEngine();  // try start engine.
//        truck.gas(1.0);
//        truck.move();
//        assertTrue(truck.getPosition().equals(new Vector2D(1, 1)));
//    }
//
//    @Test
//    public void tryToRaisePlatformWhileDriving() {
//        truck.lower(70);
//        truck.startEngine();
//        truck.gas(1.0);
//        truck.move();
//        truck.raise(70); // try set ramp to 70.
//        assertFalse(truck.isFullyRaised());
//     }
//}
//
