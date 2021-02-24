import Controller.*;
import Model.*;
import View.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // volvo
        Car volvo = new Volvo240(2,3);
        volvo.setPosition(new Vector2D(0, 0));
        cars.add(volvo);

        // saab
        Car saab95 = new Saab95(2,3);
        saab95.setPosition(new Vector2D(100, 0));
        cars.add(saab95);

        // scania
        Car scania = new Scania(200,3,5, "Scania", Color.WHITE, 2);
        scania.setPosition(new Vector2D(200, 0));
        ((Scania)scania).lower(70);
        cars.add(scania);


        // Create MVC
        IModel model = new Model(cars);
        ICarView view = new CarView("CarSim 2.0", model.getObserverHandler());
        CarController cc = new CarController(view, model);


        // Start the timer
        model.startTimer();
    }

}
