package Model;

import Observer.EventSource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;
import javax.swing.Timer;

public class Model implements IModel {

    static int carNumber;

    private final int delay = 50;
    private final Timer timer = new Timer(delay, new TimerListener());

    int boardWidth = 800;
    int boardHeight = 800;

    //  CarNumber , carKey
    // List<Integer, Integer> allCars = new HashMap<>();

    // Each car can be once in each map..
    List<ITrim> carsWithTrim;
    List<ITurboVehicle> carsWithTurbo;
    List<IRampVehicle> carsWithRamp;

    EventSource<ICarable> modelUpdatedEvent = new EventSource<>();

    // Constructor to initialize all lists. (ICarable, ITrim, ITurboVehicle, IRampVehicle)
    public Model(List<ITrim> carsWithTrim, List<ITurboVehicle> turbos, List<IRampVehicle> ramps) {
        this(carsWithTrim, turbos);
        this.carsWithRamp = ramps;

        // carMap.getOrDefault(this.hashCode(), null);
    }

    public Model(List<ITrim> carsWithTrim, List<ITurboVehicle> turbos) {
        // this.carMap = allCars;
        this.carsWithTrim = carsWithTrim;
        this.carsWithTurbo = turbos;
    }

    public Model() {
        carsWithTrim = new ArrayList<>();
        carsWithTurbo = new ArrayList<>();
        carsWithRamp = new ArrayList<>();

    }

    @Override
    public void startTimer() {
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     *
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for (int i = 0; i < carsWithTrim.size(); i++) {
                var car = carsWithTrim.get(i);
                if (isOutOfBounds(car)) {
                    carsWithTrim.remove(car);
                    carsWithTrim.add(i, car.turnAround());
                }
            }
            for (int i = 0; i < carsWithTurbo.size(); i++) {
                var car = carsWithTurbo.get(i);
                if (isOutOfBounds(car)) {
                    carsWithTurbo.remove(car);
                    carsWithTurbo.add(i, car.turnAround());
                }
            }
            for (int i = 0; i < carsWithRamp.size(); i++) {
                var car = carsWithRamp.get(i);
                if (isOutOfBounds(car)) {
                    carsWithRamp.remove(car);
                    carsWithRamp.add(i, car.turnAround());
                }
            }

            modelUpdatedEvent.publish(sumCars());
        }
    }

    boolean isOutOfBounds(ICarable car) {
        int y = (int) car.getPosition().getY();
        return y > 500 || y < 0;
    }

    private List<ICarable> sumCars() {
        List<ICarable> res = new ArrayList<>();
        res.addAll(carsWithTurbo);
        res.addAll(carsWithRamp);
        res.addAll(carsWithTrim);
        return res;
    }


    @Override
    public void startEngine() {
        for (int i = 0; i < carsWithTrim.size(); i++) {
            var car = carsWithTrim.get(i);
            carsWithTrim.remove(car);
            carsWithTrim.add(i, car.startEngine());
        }
        for (int i = 0; i < carsWithTurbo.size(); i++) {
            var car = carsWithTurbo.get(i);
            carsWithTurbo.remove(car);
            carsWithTurbo.add(i, car.startEngine());
        }
        for (int i = 0; i < carsWithRamp.size(); i++) {
            var car = carsWithRamp.get(i);
            carsWithRamp.remove(car);
            carsWithRamp.add(i, car.startEngine());
        }

    }

    @Override
    public void stopEngine() {
        for (int i = 0; i < carsWithTrim.size(); i++) {
            var car = carsWithTrim.get(i);
            carsWithTrim.remove(car);
            carsWithTrim.add(i, car.stopEngine());
        }
        for (int i = 0; i < carsWithTurbo.size(); i++) {
            var car = carsWithTurbo.get(i);
            carsWithTurbo.remove(car);
            carsWithTurbo.add(i, car.stopEngine());
        }
        for (int i = 0; i < carsWithRamp.size(); i++) {
            var car = carsWithRamp.get(i);
            carsWithRamp.remove(car);
            carsWithRamp.add(i, car.stopEngine());
        }
    }

    @Override
    public void gas(int amount) {
        for (int i = 0; i < carsWithTrim.size(); i++) {
            var car = carsWithTrim.get(i);
            carsWithTrim.remove(car);
            carsWithTrim.add(i, car.gas(amount));
        }
        for (int i = 0; i < carsWithTurbo.size(); i++) {
            var car = carsWithTurbo.get(i);
            carsWithTurbo.remove(car);
            carsWithTurbo.add(i, car.gas(amount));
        }
        for (int i = 0; i < carsWithRamp.size(); i++) {
            var car = carsWithRamp.get(i);
            carsWithRamp.remove(car);
            carsWithRamp.add(i, car.gas(amount));
        }

    }

    @Override
    public void brake(int amount) {
        for (int i = 0; i < carsWithTrim.size(); i++) {
            ITrim car = carsWithTrim.get(i);
            carsWithTrim.remove(car);
            carsWithTrim.add(car.brake(amount));
            replace(car, car.brake(amount));
        }
        for (int i = 0; i < carsWithTurbo.size(); i++) {
            ITurboVehicle car = carsWithTurbo.get(i);
            replace(car, car.brake(amount));
        }
        for (int i = 0; i < carsWithRamp.size(); i++) {
            IRampVehicle car = carsWithRamp.get(i);
            replace(car, car.brake(amount));
        }
    }
    // good?
    private void replace(ITrim remove, ITrim replace) {
        carsWithTrim.remove(remove);
        carsWithTrim.add(replace);
    }
    private void replace(ITurboVehicle remove, ITurboVehicle replace) {
        carsWithTurbo.remove(remove);
        carsWithTurbo.add(replace);
    }
    private void replace(IRampVehicle remove, IRampVehicle replace) {
        carsWithRamp.remove(remove);
        carsWithRamp.add(replace);
    }

    @Override
    public void raise() {
        for (int i = 0; i < carsWithRamp.size(); i++) {
            IRampVehicle car = carsWithRamp.get(i);
            carsWithRamp.remove(car);
            carsWithRamp.add(car.raise(10));
        }
    }

    @Override
    public void lower() {
        for (int i = 0; i < carsWithRamp.size(); i++) {
            IRampVehicle car = carsWithRamp.get(i);
            carsWithRamp.remove(car);
            carsWithRamp.add(car.lower(10));
        }
    }

    @Override
    public void setTurboOn() {
        for (int i = 0; i < carsWithTurbo.size(); i++) {
            var car = carsWithTurbo.get(i);
            carsWithTurbo.remove(car);
            carsWithTurbo.add(i, car.setTurboOn());
        }
    }

    @Override
    public void setTurboOff() {
        for (int i = 0; i < carsWithTurbo.size(); i++) {
            var car = carsWithTurbo.get(i);
            carsWithTurbo.remove(car);
            carsWithTurbo.add(i, car.setTurboOff());
        }
    }


    @Override
    public EventSource<ICarable> getModelUpdatedEvent() {
        return modelUpdatedEvent;
    }

    /**
     * Add a random type of car.
     */
    public void addCar() {
        Random r = new Random();
        int i = r.nextInt(3);

        int x = (sumCars().size()) * 100;
        switch (i) {
            case 0 -> {
                ITrim volvo = CarFactory.createVolvo240(new Vector2D(x, 0), new Vector2D(0, 1), 0, false);
                carsWithTrim.add(volvo);
            }
            case 1 -> {
                ITurboVehicle saab = CarFactory.createSaab95(new Vector2D(x, 0), new Vector2D(0, 1), 0, false, true);
                carsWithTurbo.add(saab);
            }
            case 2 -> {
                IRampVehicle scania = CarFactory.createScania(new Vector2D(x, 0), new Vector2D(0, 1), 0);
                carsWithRamp.add(scania);
            }
        }
    }

    public void removeCar() {
        Random r = new Random();
        int i = r.nextInt(3);
        if (sumCars().size() == 0) return;

        switch(i){
            case 0 -> {
                if(carsWithTrim.size() < 1) {
                    removeCar();
                    break;
                }
                int indexToRemove = r.nextInt(carsWithTrim.size());
                carsWithTrim.remove(indexToRemove);
            }
            case 1 -> {
                if(carsWithTurbo.size() < 1) {
                    removeCar();
                    break;
                }
                int indexToRemove = r.nextInt(carsWithTurbo.size());
                carsWithTurbo.remove(indexToRemove);
            }
            case 2 -> {
                if(carsWithRamp.size() < 1) {
                    removeCar();
                    break;
                }
                int indexToRemove = r.nextInt(carsWithRamp.size());
                carsWithRamp.remove(indexToRemove);
            }
        }

    }

}
