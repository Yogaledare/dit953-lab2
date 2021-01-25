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

    @Test
    public void turnSaab95LeftOnce() {
        Vector2D target = new Vector2D(-1, 0 );
        saab95.turnLeft();

        // against recommendations, but anyway..
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.01);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.01);

    }

    @Test
    public void turnSaab95RightOnce() {
        Vector2D target = new Vector2D(1, 0 );
        saab95.turnRight();

        // against recommendations, but anyway..
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.01);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.01);
    }


    @Test
    public void turnSaab95RightTwice() {
        Vector2D target = new Vector2D(0, -1 );
        saab95.turnRight();
        saab95.turnRight();

        // against recommendations, but anyway..
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.01);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.01);
    }

    @Test
    public void gasToMaxAndTryToGoAbove() {

        while (saab95.getCurrentSpeed() <= saab95.getEnginePower()) {
            saab95.gas(1);
        }

        for (int i = 0; i < 10; i++) {
            saab95.gas(1);
        }

        assertTrue(saab95.getCurrentSpeed() < saab95.getEnginePower());
    }

}
