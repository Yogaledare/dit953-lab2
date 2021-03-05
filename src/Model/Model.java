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

    Map<Integer, Integer> allCars;

    // Each car can be once in each map..
    Map<Integer, ITrim> trimCars;
    Map<Integer, ITurboVehicle> carsWithTurbo;
    Map<Integer, IRampVehicle> carsWithRamp;

    EventSource<ICarable> modelUpdatedEvent = new EventSource<>();

    // Constructor to initialize all lists. (ICarable, ITrim, ITurboVehicle, IRampVehicle)
    public Model(Map<Integer, ITrim> trimCars, Map<Integer, ITurboVehicle> turbos, Map<Integer, IRampVehicle> ramps) {
        this(trimCars, turbos);
        this.carsWithRamp = ramps;
        // carMap.getOrDefault(this.hashCode(), null);
    }

    public Model(Map<Integer, ITrim> trimCars, Map<Integer, ITurboVehicle> turbos) {
        // this.carMap = allCars;
        this.carsWithTrim = carsWithTrim;
        this.carsWithTurbo = turbos;
    }

    public Model() {
        trimCars = new HashMap<>();
        carsWithTurbo = new HashMap<>();
        carsWithRamp = new HashMap<>();
        allCars = new HashMap<>();

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
            for (Integer carKey : trimCars.keySet()) {
                trimCars.put(carKey, trimCars.get(carKey).move());
                if (isOutOfBounds(trimCars.get(carKey)))
                    trimCars.replace(carKey, trimCars.get(carKey).turnAround());
            }

            for (Integer carKey : carsWithTurbo.keySet()) {
                carsWithTurbo.put(carKey, carsWithTurbo.get(carKey).move());
                if (isOutOfBounds(carsWithTurbo.get(carKey)))
                    carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).turnAround());
            }

            for (Integer carKey : carsWithRamp.keySet()) {
                carsWithRamp.put(carKey, carsWithRamp.get(carKey).move());
                if (isOutOfBounds(carsWithRamp.get(carKey)))
                    carsWithRamp.replace(carKey, carsWithRamp.get(carKey).turnAround());
            }


            modelUpdatedEvent.publish(sumCars());
            //modelUpdatedEvent.publish(carsWithTurbo.values());
            //modelUpdatedEvent.publish(trimCars.values());
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
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).setTurboOn());
        }
    }

    @Override
    public void setTurboOff() {
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).setTurboOff());
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
                carsWithTurbo.put(saab.hashCode(), saab);
            }
            case 2 -> {
                IRampVehicle scania = CarFactory.createScania(new Vector2D(x, 0), new Vector2D(0, 1), 0);
                carsWithRamp.put(scania.hashCode(), scania);
            }
        }
    }

    public void removeCar() {
        Random r = new Random();
        int i = r.nextInt(3);
        if (sumCars().size() == 0) { return; }

        switch(i){
            case 0 -> {
                int indexToRemove = r.nextInt(carsWithTrim.size());
                if(indexToRemove == 0) return;
                carsWithTrim.remove(indexToRemove);
            }
            case 1 -> {
                int indexToRemove = r.nextInt(carsWithTurbo.size());
                carsWithTurbo.remove(indexToRemove);
            }
            case 2 -> {
                int indexToRemove = r.nextInt(carsWithRamp.size());
                carsWithRamp.remove(indexToRemove);
            }
        }

        /*
        switch (i) {
            case 0 -> cars.remove(cars.size() - 1);
            case 1 -> carsWithTurbo.remove(carsWithTurbo.size() - 1);
            case 2 -> carsWithRamp.remove(carsWithRamp.size() - 1);
        }
         */
    }

}
