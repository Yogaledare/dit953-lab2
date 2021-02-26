import Controller.*;
import Model.*;
import View.*;

import javax.swing.*;
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
        Car scania = new Scania(80,3,5, "Scania", Color.WHITE, 2);
        scania.setPosition(new Vector2D(200, 0));
        ((Scania)scania).lower(70);
        cars.add(scania);

        // Create MVC
        IModel model = new Model(cars);
        //ICarView view = new CarView("CarSim 2.0", model.getObserverHandler());




        List<JPanel> panels = new ArrayList<>();
        DrawPanel drawPanel = new DrawPanel(800, 800-240, model.getPaintHandler());
//        panels.add(new DrawPanel(800, 800-240, model.getObserverHandler()));
//        GasPanel gasPanel = new GasPanel(200, 800);
        GasPanel gasPanel = new GasPanel();
//        panels.add(gasPanel);
        ControlPanel controlPanel = new ControlPanel(800);
//        panels.add(controlPanel);
//        panels.add(new LoggerPanel(model.getLoggerHandler()));
        LoggerPanel loggerPanel = new LoggerPanel(model.getLogHandler());

        CarView view = new CarView("CarSim 2.0");

        view.addUIElement(drawPanel);
        view.addUIElement(loggerPanel);
        view.startNewRow();
        view.addUIElement(gasPanel);
        view.startNewRow();
        view.addUIElement(controlPanel);


//        CarView view = new CarView(800, 800, "CarSim 2.0", panels);

        GasController gasController = new GasController(gasPanel, model);
        ControllPanelController cPC = new ControllPanelController(controlPanel, model);

        //CarController cc = new CarController(view, model);

        // Start the timer
        model.startTimer();
    }

}
