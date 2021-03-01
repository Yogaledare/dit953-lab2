package Model;

import Observer.EventSource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

public class Model implements IModel {
    private int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    int boardWidth = 800;
    int boardHeight = 800;

    List<IMovable> cars;
    List<ITurbo>   carsWithTurbo;
    List<IRamp>    carsWithRamp;

    EventSource<IMovable> modelUpdatedEvent = new EventSource<>();

    public Model(List<Car> cars, List<ITurbo> turbos) {
        this.cars = cars;
        this.carsWithTurbo = turbos;
        // Hilfe! instanceof.. how to remove this ?
        /*
        for (Car c : cars ) {
            if (c instanceof ITurbo) {
                carsWithTurbo.add((ITurbo) c);
            }

            if (c instanceof ITrim) {
                carsWithTrim.add((ITrim) c);
            }
        }
        */
    }

    public Model() {
        cars = new ArrayList<>();
    }

    @Override
    public void startTimer() {
        timer.start();
    }

    void updateModel() {
        for (IMovable e : cars) {
            e.move();
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IMovable car : cars) {
                car.move();
                if (isOutOfBounds(car)) {
                    car.turnRight();
                    car.turnRight();
                }
            }
            modelUpdatedEvent.publish(cars);
            // logHandler.publish((List<? extends ILoggable>) cars);
        }
    }

    boolean isOutOfBounds(IMovable car) {
        int y = (int) car.getPosition().getY();
        return y > 500 || y < 0;
    }


    @Override
    public void startEngine() {
        for (IMovable e : cars) {
            e.startEngine();
        }
    }

    @Override
    public void stopEngine() {
        for (Car e : cars)
            e.stopEngine();
    }

    @Override
    public void gas(int amount) {
        for (Car e : cars) {
            e.gas(amount);
        }
    }

    @Override
    public void brake(int amount) {
        for (Car e : cars) {
            e.brake(amount);
        }
    }

    @Override
    public void raise() {
        for (Car e : cars) {
            try {
                ((Scania) e).raise(10);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void lower() {
        for (Car e : cars) {
            try {
                ((Scania) e).lower(10);
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void setTurboOn() {
        for (ITurbo turbo : carsWithTurbo) {
            turbo.setTurboOn();
        }
    }

    @Override
    public void setTurboOff() {
        for (ITurbo turbo : carsWithTurbo) {
            turbo.setTurboOff();
        }
    }

    @Override
    public EventSource<IMovable> getModelUpdatedEvent() {
        return modelUpdatedEvent;
    }

}
