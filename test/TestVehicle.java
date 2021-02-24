

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestVehicle {

    Saab95 saab95;
    Volvo240 volvo240;

    @Before
    public void setup() {
        saab95 = new Saab95(2, 5);
        volvo240 = new Volvo240(2, 4);
    }

    @Test
    public void startAndStop() {
        saab95.startEngine();
        saab95.stopEngine();
        assertEquals(0, saab95.getCurrentSpeed(), 0.0);
    }

    @Test
    public void driveOneStep() {
        saab95.startEngine();
        saab95.gas(1.0);
        saab95.move();
        Vector2D target = new Vector2D(0.0, 1.1);
        assertTrue(target.equals(saab95.getPosition()));
    }

    @Test
    public void turnLeftOnce() {
        saab95.startEngine();
        Vector2D target = new Vector2D(-1, 0);
        saab95.turnLeft();
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.05);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.05);
    }

    @Test
    public void turnRightOnce() {
        saab95.startEngine();
        Vector2D target = new Vector2D(1, 0);
        saab95.turnRight();
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.05);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.05);
    }

    @Test
    public void turnRightTwice() {
        saab95.startEngine();
        Vector2D target = new Vector2D(0, -1);
        saab95.turnRight();
        saab95.turnRight();
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.05);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.05);
    }

    @Test
    public void gasToMaxAndTryToGoAbove() {
        saab95.startEngine();

        while (saab95.getCurrentSpeed() < saab95.getEnginePower()) {
            saab95.gas(1);
        }
        for (int i = 0; i < 10; i++) {
            saab95.gas(1);
        }
        assertTrue(saab95.getCurrentSpeed() <= saab95.getEnginePower());
    }

    @Test
    public void tryGasWithEngineOff() {
        // car.startEngine();
        for (int i = 0; i < 10; i++) {
            saab95.gas(1);
            saab95.move();
        }

        assertEquals(0, saab95.getCurrentSpeed(), 0);
    }

    @Test
    public void tryToBreakBelowZero() {
        saab95.startEngine();

        for (int i = 0; i < 10; i++) {
            saab95.brake(1);
        }
        assertEquals(0, saab95.getCurrentSpeed(), 0.1);
    }

    @Test
    public void turnTurboOn() {
        saab95.setTurboOff();
        saab95.setTurboOn();
        assertTrue(saab95.getTurboOn());
    }

    @Test
    public void turnTurboOff() {
        saab95.setTurboOn();
        saab95.setTurboOff();
        assertFalse(saab95.getTurboOn());
    }

    @Test
    public void checkThatNrOfDoorsIsPositive() {
        assertTrue(saab95.getNoOfDoors() >= 0);
    }

    @Test
    public void checkThatClampClampsCorrectly() {
        double[] ds = {-16.3, 0.5, 24.8};
        double[] key = {0, 0.5, 1};
        double min = 0;
        double max = 1;

        for (int i = 0; i < ds.length; i++) {
            ds[i] = Vector2D.clamp(ds[i], min, max);
        }

        for (int i = 0; i < ds.length; i++) {
            assertEquals(ds[i], key[i], 0.0);
        }
    }

}