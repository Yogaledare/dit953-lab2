import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo = new Volvo240(2, 4);
        volvo.setPosition(new Vector2D(0, 0));
        cc.cars.add(volvo);

        Saab95 saab = new Saab95(2, 0);
        saab.setPosition(new Vector2D(100, 0));
        cc.cars.add(saab);



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
//        cc.frame.drawPanel.connectCars(cc.cars);
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
//                int x = (int) Math.round(car.getPosition().getX());
//                int y = (int) Math.round(car.getPosition().getY());
                TurnAround(car);
//                frame.drawPanel.moveit(car, x, y);
                // repaint() calls the paintComponent method of the panel
                // frame.drawPanel.repaint(); // repaint was called for each car..
            }
            frame.drawPanel.repaint();
        }
    }

    void TurnAround(Car car){
        int y = (int)car.getPosition().getY();
        if(y > 500 || y < 0){
            car.setDirection(car.getDirection().multiplyByScalar(-1));
        }

    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void startEngineAll(){
        for (Car c : cars ) {
            c.startEngine();
        }
    }

    void stopEngineAll(){
        for (Car c : cars ) {
            c.stopEngine();
        }
    }

    /**
     * Scania specific raise platform
     */
    void raise() {
        for (Car c : cars ) {
            try {
                ((Scania) c).raise(10);
            } catch( Exception ex) {

            }
        }

    }

    /**
     * Scania specific lower platform.
     */
    void lower() {
        for (Car c : cars ) {
            try {
                ((Scania) c).lower(10);
            } catch( Exception ex) {

            }
        }

    }

    /**
     * Saab95 specific turboOn
     */
    void setTurboOn(){
        for(Car c : cars){
            try{
                ((Saab95) c).setTurboOn();
            }
            catch(Exception ex){
                // System.err.println("Error:" + ex.toString());
            }

        }
    }

    /**
     * Saab95 specific turboOff
     */
    void setTurboOff(){
        for(Car c : cars){
            try{
                ((Saab95) c).setTurboOff();
            }
            catch(ClassCastException ex){
//                System.err.println("Error:" + ex.toString());
            }

        }
    }


}
