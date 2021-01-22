import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCar {
    Car saab95;

    @Before
    public void setupSaab() {
        saab95 = new Saab95();
    }

    @Test
    public void testGetSaab95ModelName() {
        assertEquals("Saab95", saab95.getModelName());
    }

    @Test
    public void startAndStopSaab95() {
        saab95.startEngine();
        saab95.stopEngine();
        assertEquals(0, saab95.getCurrentSpeed(), 0.0);
    }

    @Test
    public void driveSaab95OneStep() {
        saab95.startEngine();
        saab95.gas(1.0);
        saab95.move();
        Vector2D target = new Vector2D(0.0,1.35);
        System.out.println(saab95.getPosition().getY());
        assertEquals(saab95.getPosition().getY(), target.getY(), 0.0);


    }

}
