import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestScania {
    @Test
    public void tryToDriveScaniaTruckWhenPlattformIsDown() {
        truck.raisePlatform();

        truck.startEngine();
        truck.gas(1.0);

        truck.move();
        System.out.println("speed: " + truck.getCurrentSpeed());
        assertTrue(truck.getPosition().equals(new Vector2D(0, 0)));
    }

    public void tryToRaisePlatformWhileDriving() {
        truck.startEngine();
        truck.gas(1.0);

    }

}
