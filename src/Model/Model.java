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

    List<IVehicle> cars;
    List<ITurboVehicle>   carsWithTurbo;
    List<IRampVehicle>    carsWithRamp;

    EventSource<IVehicle> modelUpdatedEvent = new EventSource<>();

    public Model(List<IVehicle> cars, List<ITurboVehicle> turbos, List<IRampVehicle> ramps) {
        this(cars, turbos);
        this.carsWithRamp = ramps;

    }

    public Model(List<IVehicle> cars, List<ITurboVehicle> turbos) {
        this.cars = cars;
        this.carsWithTurbo = turbos;
    }

    public Model() {
        cars = new ArrayList<>();
    }

    @Override
    public void startTimer() {
        timer.start();
    }

    void updateModel() {
        for (IVehicle e : cars) {
            e.move();
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle car : cars) {
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

    boolean isOutOfBounds(IVehicle car) {
        int y = (int) car.getPosition().getY();
        return y > 500 || y < 0;
    }


    @Override
    public void startEngine() {
        for (IVehicle e : cars) {
            e.startEngine();
        }
    }

    @Override
    public void stopEngine() {
        for (IVehicle e : cars)
            e.stopEngine();
    }

    @Override
    public void gas(int amount) {
        for (IVehicle e : cars) {
            e.gas(amount);
        }
    }

    @Override
    public void brake(int amount) {
        for (IVehicle e : cars) {
            e.brake(amount);
        }
    }

    @Override
    public void raise() {
        for (IRampVehicle e : carsWithRamp) {
            e.raise(10);
        }
    }

    @Override
    public void lower() {
        for (IRampVehicle e : carsWithRamp) {
          e.lower(10);
        }
    }

    @Override
    public void setTurboOn() {
        for (ITurboVehicle turbo : carsWithTurbo) {
            turbo.setTurboOn();
        }
    }

    @Override
    public void setTurboOff() {
        for (ITurboVehicle turbo : carsWithTurbo) {
            turbo.setTurboOff();
        }
    }

    @Override
    public EventSource<IVehicle> getModelUpdatedEvent() {
        return modelUpdatedEvent;
    }

    public void addCar() {
        Random r = new Random();
        int i = r.nextInt(3);
        int x = cars.size() * 100;
        switch(i){
            case 0:
                cars.add(CarFactory.createVolvo240(new Vector2D(x, 0)));
                break;
            case 1:
                ITurboVehicle saab = CarFactory.createSaab95(new Vector2D(x, 0));
                cars.add(saab);
                carsWithTurbo.add(saab);
                break;
            case 2:
                IRampVehicle scania = CarFactory.createScania(new Vector2D(x, 0));
                cars.add(scania);
                carsWithRamp.add(scania);
                break;
            default:
                cars.add(CarFactory.createVolvo240(new Vector2D(x, 0)));
        }
    }

    public void removeCar() {
        int i = cars.size();
        cars.remove(i-1);
    }
}
