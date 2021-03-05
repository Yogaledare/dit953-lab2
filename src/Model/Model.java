package Model;

import Observer.EventSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

public class Model implements IModel {
    private final int delay = 50;
    private final Timer timer = new Timer(delay, new TimerListener());

    int boardWidth = 800;
    int boardHeight = 800;

    // All Cars in this map

    // Map<Integer, ICarable>      carMap = new HashMap<>();

    // Each car can be once in each map..
    Map<Integer, ITrim>         trimCars;
    Map<Integer, ITurboVehicle> carsWithTurbo;
    Map<Integer, IRampVehicle>  carsWithRamp;

    EventSource<ITrim> modelUpdatedEvent = new EventSource<>();

    // Constructor to initialize all lists. (ICarable, ITrim, ITurboVehicle, IRampVehicle)
    public Model( Map<Integer,ITrim> trimCars, Map<Integer,ITurboVehicle> turbos, Map<Integer,IRampVehicle> ramps) {
        this(trimCars, turbos);
        this.carsWithRamp = ramps;
        // carMap.getOrDefault(this.hashCode(), null);
    }

    public Model(Map<Integer,ITrim> trimCars, Map<Integer,ITurboVehicle> turbos) {
        // this.carMap = allCars;
        this.trimCars = trimCars;
        this.carsWithTurbo = turbos;
    }


    public Model() {
        // carMap = new HashMap<>();

        trimCars = new HashMap<>();
        carsWithTurbo = new HashMap<>();
        carsWithRamp = new HashMap<>();
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
                if (isOutOfBounds(trimCars.get(carKey)))
                    trimCars.get(carKey).turnAround();
            }
            modelUpdatedEvent.publish(trimCars.values());

        }
    }

    boolean isOutOfBounds(ICarable car) {
        int y = (int) car.getPosition().getY();
        return y > 500 || y < 0;
    }


    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public void gas(int amount) {
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).gas(amount));
        }
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).gas(amount));
        }
    }

    @Override
    public void brake(int amount) {
        for (Integer carKey : carsWithTurbo.keySet()) {
            carsWithTurbo.replace(carKey, carsWithTurbo.get(carKey).brake(amount));
        }
        for (Integer carKey : carsWithRamp.keySet()) {
            carsWithRamp.replace(carKey, carsWithRamp.get(carKey).brake(amount));
        }
    }

    @Override
    public void raise() {

    }

    @Override
    public void lower() {

    }

    @Override
    public void setTurboOn() {

    }

    @Override
    public void setTurboOff() {

    }

//    private void exchangeItems(List<ICarable> oldL, List<ICarable> newL){
////        allCars.removeAll(oldL);
////        trimCars.removeAll(oldL);
////        carsWithRamp.removeAll(oldL);
////        carsWithTurbo.removeAll(oldL);
////
////       allCars.addAll(newL);
////        trimCars.addAll(newL);
////        carsWithRamp.addAll(newL);
////        carsWithTurbo.addAll(newL);
//    }
//
//    private void exchangeItemsTurbo(List<ITurboVehicle> oldL, List<ITurboVehicle> newL){
//        carsWithTurbo.removeAll(oldL);
////        allCars.removeAll(oldL);
//
//        carsWithTurbo.addAll(newL);
////        allCars.addAll(newL);
//    }
//
//    private void exchangeItemsRamp(List<IRampVehicle> oldL, List<IRampVehicle> newL){
//        carsWithRamp.removeAll(oldL);
////        allCars.removeAll(oldL);
//
//        carsWithRamp.addAll(newL);
////        allCars.addAll(newL);
//    }
//
//    private void exchangeItemsTrim(List<ITrim> oldL, List<ITrim> newL){
//        trimCars.removeAll(oldL);
////        allCars.removeAll(oldL);
//
//        trimCars.addAll(newL);
////        allCars.addAll(newL);
//    }

    @Override
    public EventSource<ICarable> getModelUpdatedEvent() {
        return modelUpdatedEvent;
    }

    public void addCar() {
        Random r = new Random();
        int i = r.nextInt(3);
        int x = 1 * 100;
        switch (i) {
            case 0 -> {
                ITrim volvo = CarFactory.createVolvo240(new Vector2D(x, 0), new Vector2D(0, 0), 0, false);
  //              carMap.put(volvo.hashCode(), volvo);
                trimCars.put(volvo.hashCode(), volvo);
            }
            case 1 -> {
                ITurboVehicle saab = CarFactory.createSaab95(new Vector2D(x, 0), new Vector2D(0, 0), 0, false, true);
//                carMap.put(saab.hashCode(), saab);
                carsWithTurbo.put(saab.hashCode(), saab);

            }
            case 2 -> {
                IRampVehicle scania = CarFactory.createScania(new Vector2D(x, 0), new Vector2D(0, 0), 0);
//                carMap.put(scania.hashCode(), scania);
                carsWithRamp.put(scania.hashCode(), scania);

            }
        }
    }

    public void removeCar() {
        Random r = new Random();
//        int removeLast = carMap.size() - 1;

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
