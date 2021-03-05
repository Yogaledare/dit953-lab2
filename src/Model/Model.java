package Model;

import Observer.EventSource;
import View.IPaintable;

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
        for (Integer carKey : ramps.keySet()) {
            this.allCars.put(carNumber++, ramps.get(carKey).hashCode());
        }

    }

    public Model(Map<Integer, ITrim> trimCars, Map<Integer, ITurboVehicle> turbos) {
        // this.carMap = allCars;
        this.trimCars = trimCars;
        this.carsWithTurbo = turbos;
        for (Integer carKey : trimCars.keySet()) {
            this.allCars.put(carNumber++, trimCars.get(carKey).hashCode());
        }
        for (Integer carKey : turbos.keySet()) {
            this.allCars.put(carNumber++, turbos.get(carKey).hashCode());
        }


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
        List<ICarable> totalCars = new ArrayList<ICarable>();
        totalCars.addAll(carsWithTurbo.values());
        totalCars.addAll(carsWithRamp.values());
        totalCars.addAll(trimCars.values());
        return totalCars;
    }


    @Override
    public void startEngine() {
        for (Integer carKey : trimCars.keySet()) {
            trimCars.replace(carKey, trimCars.get(carKey).startEngine());
        }
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).startEngine());
        }
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).startEngine());
        }
    }

    @Override
    public void stopEngine() {
        for (Integer carKey : trimCars.keySet()) {
            trimCars.replace(carKey, trimCars.get(carKey).stopEngine());
        }
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).stopEngine());
        }
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).stopEngine());
        }
    }

    @Override
    public void gas(int amount) {
        for (Integer carKey : trimCars.keySet()) {
            trimCars.replace(carKey, trimCars.get(carKey).gas(amount));
        }
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).gas(amount));
        }
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).gas(amount));
        }

    }

    @Override
    public void brake(int amount) {
        for (Integer carKey : trimCars.keySet()) {
            trimCars.replace(carKey, trimCars.get(carKey).brake(amount));
        }
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).brake(amount));
        }
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).brake(amount));
        }
    }

    @Override
    public void raise() {
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).raise(10));
        }

    }

    @Override
    public void lower() {
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).lower(1.0));
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
                trimCars.put(volvo.hashCode(), volvo);
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
        int removeLast = sumCars().size() - 1;

        // if(toRemove == null) return;
        try {
//            int removedCar = carMap.remove(removeLast).hashCode();
//            carsWithTurbo.remove(removedCar);
//            carsWithRamp.remove(removedCar);
        } catch (IndexOutOfBoundsException ignore) {
            // say nothing.
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
