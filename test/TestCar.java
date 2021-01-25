import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;

public class TestCar {

    List<Car> cars = new ArrayList<>();

    Car saab95;

    @Before
    public void setup() {


        cars.add(new Saab95());
        cars.add(new Volvo240());
//        cars.add(new saab95());


        saab95 = new Saab95();
    }

/*    @Test
    public void testGetSaab95ModelName() {
        for (Car car : cars) {
            assertEquals("Saab95", car.getModelName());
        }
    }*/

    @Test
    public void startAndStop() {
        for (Car car : cars) {
            car.startEngine();
            car.stopEngine();
            assertEquals(0, car.getCurrentSpeed(), 0.0);
        }
    }

    @Test
    public void driveOneStep() {
        for (Car car : cars) {
            car.startEngine();
            car.gas(1.0);
            car.move();
            Vector2D target = new Vector2D(0.0,1.35);
//            System.out.println(car.getPosition().getY());
            assertEquals(car.getPosition().getY(), target.getY(), 0.0);
        }
    }

    @Test
    public void turnLeftOnce() {
        for (Car car : cars) {
            Vector2D target = new Vector2D(-1, 0 );
            car.turnLeft();
            assertEquals(target.getX(), car.getDirection().getX(), 0.01);
            assertEquals(target.getY(), car.getDirection().getY(), 0.01);
        }
    }

    @Test
    public void turnRightOnce() {
        for (Car car : cars) {
            Vector2D target = new Vector2D(1, 0 );
            car.turnRight();
            assertEquals(target.getX(), car.getDirection().getX(), 0.01);
            assertEquals(target.getY(), car.getDirection().getY(), 0.01);
        }
    }


    @Test
    public void turnRightTwice() {
        for (Car car : cars) {
            Vector2D target = new Vector2D(0, -1 );
            car.turnRight();
            car.turnRight();
            assertEquals(target.getX(), car.getDirection().getX(), 0.01);
            assertEquals(target.getY(), car.getDirection().getY(), 0.01);
        }
    }

    @Test
    public void paintYellow() {
        for (Car car : cars) {
            car.setColor(Color.YELLOW);
            assertEquals(Color.YELLOW, car.getColor());
        }
    }

    @Test
    public void gasToMaxAndTryToGoAbove() {
        for (Car car : cars) {
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
    public void checkForValidModelNames() {
        List<String> validModelNames = Arrays.asList("Saab95", "Volvo240");

        for (Car car : cars) {
            assertTrue(validModelNames.contains(car.getModelName()));
        }
    }

    @Test
    public void tryToBreakBelowZero() {
        for (Car car : cars) {

            for (int i = 0; i < 10; i++) {
                car.brake(1);
            }
            assertEquals(0, car.getCurrentSpeed(), 0.0);
        }
    }

    @Test
    public void checkThatSpeedFactorIsPositive() {
        for (Car car : cars) {
            assertTrue(car.findSpeedFactor() >= 0);
        }
    }

    @Test
    public void turnTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
                ((Saab95) car).setTurboOn();
                assertTrue(((Saab95) car).getTurboOn());
            }
        }
    }

    @Test
    public void turnTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
                ((Saab95) car).setTurboOff();
                assertFalse(((Saab95) car).getTurboOn());
            }
        }
    }


    @Test
    public void checkThatNrOfDoorsIsPositive() {
        for (Car car : cars) {
            assertTrue(car.getNrDoors() >= 0);
        }
    }



    // todo testa clamp


}


        /*
        saab95.startEngine();
        saab95.gas(1.0);
        saab95.move();
        Vector2D target = new Vector2D(0.0,1.35);
        System.out.println(saab95.getPosition().getY());
        assertEquals(saab95.getPosition().getY(), target.getY(), 0.0);
*/



        /*Vector2D target = new Vector2D(-1, 0 );
        saab95.turnLeft();*/

// against recommendations, but anyway..



// against recommendations, but anyway..
