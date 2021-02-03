import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;

public class TestVehicle {

    List<Vehicle> cars = new ArrayList<>();

    @Before
    public void setup() {
        cars.add(new Saab95());
        cars.add(new Volvo240());
    }

    @Test
    public void startAndStop() {
        for (Vehicle car : cars) {
            car.startEngine();
            car.stopEngine();
            assertEquals(0, car.getCurrentSpeed(), 0.0);
        }
    }

    @Test
    public void driveOneStep() {
        for (Vehicle car : cars) {
            car.startEngine();
            // car.gas(1.0, );
            car.moveForward();
            Vector2D target = new Vector2D(0.0,1.35);
            assertEquals(car.getPosition().getY(), target.getY(), 0.0);
        }
    }

    @Test
    public void turnLeftOnce() {
        for (Vehicle car : cars) {
            Vector2D target = new Vector2D(-1, 0 );
            car.turnLeft();
            assertEquals(target.getX(), car.getDirection().getX(), 0.01);
            assertEquals(target.getY(), car.getDirection().getY(), 0.01);
        }
    }

    @Test
    public void turnRightOnce() {
        for (Vehicle car : cars) {
            Vector2D target = new Vector2D(1, 0 );
            car.turnRight();
            assertEquals(target.getX(), car.getDirection().getX(), 0.01);
            assertEquals(target.getY(), car.getDirection().getY(), 0.01);
        }
    }

    @Test
    public void turnRightTwice() {
        for (Vehicle car : cars) {
            Vector2D target = new Vector2D(0, -1 );
            car.turnRight();
            car.turnRight();
            assertEquals(target.getX(), car.getDirection().getX(), 0.01);
            assertEquals(target.getY(), car.getDirection().getY(), 0.01);
        }
    }

    @Test
    public void paintYellow() {
        for (Vehicle car : cars) {
            car.setColor(Color.YELLOW);
            assertEquals(Color.YELLOW, car.getColor());
        }
    }

    @Test
    public void gasToMaxAndTryToGoAbove() {
        for (Vehicle car : cars) {
            car.startEngine();

            while (car.getCurrentSpeed() < car.getEnginePower()) {
                car.gas(1);
            }
            for (int i = 0; i < 10; i++) {
                car.gas(1);
            }
            assertTrue(car.getCurrentSpeed() <= car.getEnginePower());
        }
    }

    @Test
    public void tryGasWithEngineOff() {
        for (Vehicle car : cars) {

            // car.startEngine();
            for (int i = 0; i < 10; i++) {
                car.gas(1);
                car.move();
            }

            assertEquals(0 , car.getCurrentSpeed(),0);
        }
    }

    @Test 
    public void checkForValidModelNames() {
        List<String> validModelNames = Arrays.asList("Saab95", "Volvo240");
        for (Vehicle car : cars) {
            assertTrue(validModelNames.contains(car.getModelName()));
        }
    }

    @Test
    public void tryToBreakBelowZero() {
        for (Vehicle car : cars) {
            car.startEngine();

            for (int i = 0; i < 10; i++) {
                car.brake(1);
            }
            assertEquals(0, car.getCurrentSpeed(), 0.0);
        }
    }

    @Test
    public void checkThatSpeedFactorIsPositive() {
        for (Vehicle car : cars) {
            assertTrue(car.findSpeedFactor() >= 0);
        }
    }

    @Test
    public void turnTurboOn() {
        for (Vehicle car : cars) {
            if (car instanceof AuxTurbo) {
                ((Saab95) car).setTurboOff();
                ((Saab95) car).setTurboOn();
                assertTrue(((Saab95) car).getTurboOn());
            }
        }
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
