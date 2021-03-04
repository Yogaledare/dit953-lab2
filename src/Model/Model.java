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

    List<ICarable>        allCars;
    List<IVehicle>        cars;
    List<ITurboVehicle>   carsWithTurbo;
    List<IRampVehicle>    carsWithRamp;

    EventSource<IVehicle> modelUpdatedEvent = new EventSource<>();

    public Model(List<ICarable> allCars, List<IVehicle> cars, List<ITurboVehicle> turbos, List<IRampVehicle> ramps) {
        this(allCars, cars, turbos);
        this.carsWithRamp = ramps;

    }

    public Model(List<ICarable> allCars, List<IVehicle> cars, List<ITurboVehicle> turbos) {
        this.allCars = allCars;
        this.cars = cars;
        this.carsWithTurbo = turbos;
    }

    public Model() {
        allCars = new ArrayList<>();
        cars = new ArrayList<>();

    }

    @Override
    public void startTimer() {
        timer.start();
    }

    void updateModel() {
        for (var e : allCars) {
            e.move();
        }
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for (var e : allCars) {
                e.move();
                if (isOutOfBounds(e))
                    e.turnAround();
            }
            modelUpdatedEvent.publish(cars);
            // logHandler.publish((List<? extends ILoggable>) cars);
        }
    }

    boolean isOutOfBounds(ICarable car) {
        int y = (int) car.getPosition().getY();
        return y > 500 || y < 0;
    }


    @Override
    public void startEngine() {
        for (var e : allCars)
            e.startEngine();

    }

    @Override
    public void stopEngine() {
        for (var e : allCars)
            e.stopEngine();


    }

    @Override
    public void gas(int amount) {
        for (var e : allCars)
            e.gas(amount);

    }

    @Override
    public void brake(int amount) {
        for (var e : allCars)
            e.brake(amount);

    }

    @Override
    public void raise() {
        for (var e : carsWithRamp) {
            e.raise(10);
        }
    }

    @Override
    public void lower() {
        for (var e : carsWithRamp) {
          e.lower(10);
        }
    }

    @Override
    public void setTurboOn() {
        for (var turbo : carsWithTurbo) {
            turbo.setTurboOn();
        }
    }

    @Override
    public void setTurboOff() {
        for (var turbo : carsWithTurbo) {
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
        int x = allCars.size() * 100;
        switch(i){
            case 0:
                cars.add(CarFactory.createVolvo240(new Vector2D(x, 0), new Vector2D(0, 0), 0, false));
                break;
            case 1:
                ITurboVehicle saab = CarFactory.createSaab95(new Vector2D(x, 0), new Vector2D(0, 0), 0, false, true);
                // cars.add(saab);
                carsWithTurbo.add(saab);
                break;
            case 2:
                IRampVehicle scania = CarFactory.createScania(new Vector2D(x, 0), new Vector2D(0, 0), 0, false);
                // cars.add(scania);
                carsWithRamp.add(scania);
                break;
//            default:
//                cars.add(CarFactory.createVolvo240(new Vector2D(x, 0), new Vector2D(0, 0), 0, false));
        }
    }

    public void removeCar() {
        Random r = new Random();
        int i = r.nextInt(3);

        switch (i) {
            case 0:
                cars.remove(cars.size()-1);
                break;
            case 1:
                carsWithTurbo.remove(carsWithTurbo.size()-1);
                break;
            case 2:
                carsWithRamp.remove(carsWithRamp.size()-1);
                break;


        }

    }
}
