/*

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
        Vector2D target = new Vector2D(-1, 0);
        saab95.turnLeft();
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.01);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.01);
    }

    @Test
    public void turnRightOnce() {
        Vector2D target = new Vector2D(1, 0);
        saab95.turnRight();
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.01);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.01);
    }

    @Test
    public void turnRightTwice() {
        Vector2D target = new Vector2D(0, -1);
        saab95.turnRight();
        saab95.turnRight();
        assertEquals(target.getX(), saab95.getDirection().getX(), 0.01);
        assertEquals(target.getY(), saab95.getDirection().getY(), 0.01);
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
    public void checkThatTurboFactorIsPositive() {
        assertTrue(saab95.findTurboFactor() >= 0);
    }

    @Test
    public void turnTurboOn() {
        saab95.setTurboOff();
        saab95.setTurboOn();
        assertTrue(saab95.getTurboOn());
    }

    @Test
    public void turnTurboOff() {
        for (Vehicle car : cars) {
            if (car instanceof AuxTurbo) {
                ((Saab95) car).setTurboOn();
                ((Saab95) car).setTurboOff();
                assertFalse(((Saab95) car).getTurboOn());
            }
        }
    }

    @Test
    public void checkThatNrOfDoorsIsPositive() {
        for (Vehicle car : cars) {
            assertTrue(car.getNrDoors() >= 0);
        }
    }

    @Test
    public void checkThatClampClampsCorrectly() {
        double[] ds = {-16.3, 0.5, 24.8};
        double[] key = {0, 0.5, 1};
        double min = 0;
        double max = 1;

        for (int i = 0; i < ds.length;i++) {
            ds[i] = Vector2D.clamp(ds[i], min, max);
        }

        for (int i = 0; i < ds.length; i++) {
            assertEquals(ds[i], key[i], 0.0);
        }
    }

}