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
            //for (ITrim car : carsWithTrim) {
            //    car = replace(car, car.move());
            //    if (isOutOfBounds(car)) {
            //        replace(car, car.turnAround());
            //    }
            //}
            for (int i = 0; i < carsWithTrim.size(); i++){
                carsWithTrim.set(i, carsWithTrim.get(i).move());
                if(isOutOfBounds(carsWithTrim.get(i))){
                    carsWithTrim.set(i, carsWithTrim.get(i).turnAround());
                }
            }
            //for (ITurboVehicle car : carsWithTurbo) {
            //    car = replace(car, car.move());
            //    if (isOutOfBounds(car)) {
            //        replace(car, car.turnAround());
            //    }
            //}
            for (int i = 0; i < carsWithTurbo.size(); i++){
                carsWithTurbo.set(i, carsWithTurbo.get(i).move());
                if(isOutOfBounds(carsWithTurbo.get(i))){
                    carsWithTurbo.set(i, carsWithTurbo.get(i).turnAround());
                }
            }
            //for (IRampVehicle car : carsWithRamp) {
            //    car = replace(car, car.move());
            //    if (isOutOfBounds(car)) {
            //        replace(car, car.turnAround());
            //    }
            //}
            for (int i = 0; i < carsWithRamp.size(); i++){
                carsWithRamp.set(i, carsWithRamp.get(i).move());
                if(isOutOfBounds(carsWithRamp.get(i))){
                    carsWithRamp.set(i, carsWithRamp.get(i).turnAround());
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
        //for (ITrim car : carsWithTrim) {
        //    replace(car, car.startEngine());
        //}
        for(int i = 0; i < carsWithTrim.size(); i++){
            carsWithTrim.set(i, carsWithTrim.get(i).startEngine());
        }
        //for (ITurboVehicle car : carsWithTurbo) {
        //    replace(car, car.startEngine());
        //}
        for(int i = 0; i < carsWithTurbo.size(); i++){
            carsWithTurbo.set(i, carsWithTurbo.get(i).startEngine());
        }
        //for (IRampVehicle car : carsWithRamp) {
        //    replace(car, car.startEngine());
        //}
        for(int i = 0; i < carsWithRamp.size(); i++){
            carsWithRamp.set(i, carsWithRamp.get(i).startEngine());
        }
    }

    @Override
    public void stopEngine() {
        //for (ITrim car : carsWithTrim) {
        //    replace(car, car.stopEngine());
        //}
        for(int i = 0; i < carsWithTrim.size(); i++){
            carsWithTrim.set(i, carsWithTrim.get(i).stopEngine());
        }
        //for (ITurboVehicle car : carsWithTurbo) {
        //    replace(car, car.stopEngine());
        //}
        for(int i = 0; i < carsWithTurbo.size(); i++){
            carsWithTurbo.set(i, carsWithTurbo.get(i).stopEngine());
        }
        //for (IRampVehicle car : carsWithRamp) {
        //    replace(car, car.stopEngine());
        //}
        for(int i = 0; i < carsWithRamp.size(); i++){
            carsWithRamp.set(i, carsWithRamp.get(i).stopEngine());
        }
    }

    @Override
    public void gas(int amount) {
        //for (ITrim car : carsWithTrim) {
        //    replace(car, car.gas(amount));
        //}
        for(int i = 0; i < carsWithTrim.size(); i++){
            carsWithTrim.set(i, carsWithTrim.get(i).gas(amount));
        }
        //for (ITurboVehicle car : carsWithTurbo) {
        //    replace(car, car.gas(amount));
        //}
        for(int i = 0; i < carsWithTurbo.size(); i++){
            carsWithTurbo.set(i, carsWithTurbo.get(i).gas(amount));
        }
        //for (IRampVehicle car : carsWithRamp) {
        //    replace(car, car.gas(amount));
        //}
        for(int i = 0; i < carsWithRamp.size(); i++){
            carsWithRamp.set(i, carsWithRamp.get(i).gas(amount));
        }
    }

    @Override
    public void brake(int amount) {
        //for (ITrim car : carsWithTrim) {
        //    replace(car, car.brake(amount));
        //}
        for(int i = 0; i < carsWithTrim.size(); i++){
            carsWithTrim.set(i, carsWithTrim.get(i).brake(amount));
        }
        //for (ITurboVehicle car : carsWithTurbo) {
        //    replace(car, car.brake(amount));
        //}
        for(int i = 0; i < carsWithTurbo.size(); i++){
            carsWithTurbo.set(i, carsWithTurbo.get(i).brake(amount));
        }
        //for (IRampVehicle car : carsWithRamp) {
        //    replace(car, car.brake(amount));
        //}
        for(int i = 0; i < carsWithRamp.size(); i++){
            carsWithRamp.set(i, carsWithRamp.get(i).brake(amount));
        }
    }
    // good?
    private ITrim replace(ITrim remove, ITrim replace) {
        carsWithTrim.remove(remove);
        carsWithTrim.add(replace);
        return replace;
    }
    private ITurboVehicle replace(ITurboVehicle remove, ITurboVehicle replace) {
        carsWithTurbo.remove(remove);
        carsWithTurbo.add(replace);
        return replace;
    }
    private IRampVehicle replace(IRampVehicle remove, IRampVehicle replace) {
        carsWithRamp.remove(remove);
        carsWithRamp.add(replace);
        return replace;
    }

    @Override
    public void raise() {
        //for (IRampVehicle car : carsWithRamp) {
        //    replace(car, car.raise(10));
        //}
        for(int i = 0; i < carsWithRamp.size(); i++){
            carsWithRamp.set(i, carsWithRamp.get(i).raise(10));
        }
    }

    @Override
    public void lower() {
        //for (IRampVehicle car : carsWithRamp) {
        //    replace(car, car.lower(10));
        //}
        for(int i = 0; i < carsWithRamp.size(); i++){
            carsWithRamp.set(i, carsWithRamp.get(i).lower(10));
        }
    }

    @Override
    public void setTurboOn() {
        //for (ITurboVehicle car : carsWithTurbo) {
        //    replace(car, car.setTurboOn());
        //}
        for(int i = 0; i < carsWithTurbo.size(); i++){
            carsWithTurbo.set(i, carsWithTurbo.get(i).setTurboOn());
        }
    }

    @Override
    public void setTurboOff() {
        //for (ITurboVehicle car : carsWithTurbo) {
        //    replace(car, car.setTurboOff());
        //}
        for(int i = 0; i < carsWithTurbo.size(); i++){
            carsWithTurbo.set(i, carsWithTurbo.get(i).setTurboOff());
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
        if (sumCars().size() < 10) {
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
