import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestScania {
    Scania truck;
    Volvo240 volvo240;
    @Before
    public void setUp() {
        truck = new Scania();
        volvo240 = new Volvo240();
    }

    @Test
    public void tryToDriveScaniaTruckWhenPlattformIsUp() {
        truck.raiseRamp();

        truck.startEngine();
        truck.gas(1.0);

        truck.move();
        // System.out.println("speed: " + truck.getCurrentSpeed());
        assertTrue(truck.getPosition().equals(new Vector2D(0, 0)));
    }

    @Test
    public void tryToRaisePlatformWhileDriving() {
        truck.startEngine();
        truck.gas(1.0);

        truck.raiseRamp();

        truck.move();
        assertEquals(0, truck.getRampAngle(), 0.1);
     }

     @Test
    public void storeCarOnPlatformWithoutSettingRampAngle() {

        truck.store(volvo240);
        assertEquals(0, truck.getNumberOfCars());
     }

    @Test
    public void storeCarOnPlatformWithOpenRamp() {
        truck.lowerRamp();
        truck.store(volvo240);
        assertEquals(1, truck.getNumberOfCars());

    }


}
