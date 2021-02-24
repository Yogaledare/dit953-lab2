import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import Model.*;
import View.*;
import Controller.*;



public class Model implements IModel {
    private int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    int boardWidth = 800;
    int boardHeight = 800;

    List<Car> cars;

    ObserverHandler observerHandler = new ObserverHandler();

    public Model(List<Car> cars) {
        this.cars = cars;
    }

    public Model() {
        cars = new ArrayList<>();
    }

    @Override
    public void startTimer() {
        timer.start();
    }

    void updateModel() {
        for (Car e : cars) {
            e.move();
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                if (isOutOfBounds(car)) {
                    car.turnAround();
                }
            }
            observerHandler.publish(cars);
        }
    }

    boolean isOutOfBounds(Car car) {
        int y = (int) car.getPosition().getY();
        return y > 500 || y < 0;
    }


    @Override
    public void startEngine() {
        for (Car e : cars) {
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
        for (Car e : cars) {
            try {
                ((Saab95) e).setTurboOn();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void setTurboOff() {
        for (Car e : cars) {
            try {
                ((Saab95) e).setTurboOff();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public ObserverHandler getObserverHandler() {
        return observerHandler;
    }

}
