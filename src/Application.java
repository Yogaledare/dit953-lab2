import Controller.*;
import Model.*;
import View.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the main application.
 * hardcoded arguments exists in this class only.
 */
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

        // First view is a full-blow MVC,
        // includes a car-world, controls, speed-log
        makeView1(model);

        // Second view includes car-controls only
        makeView2(model);

        // Start the timer
        model.startTimer();
    }

    private static void makeView1(IModel m) {
        List<JPanel> panels = new ArrayList<>();
        DrawPanel drawPanel = new DrawPanel(800, 800-240, m.getPaintHandler());

        GasPanel gasPanel = new GasPanel();
        ControlPanel controlPanel = new ControlPanel(800);

        LoggerPanel loggerPanel = new LoggerPanel(m.getLogHandler());
        CarView view = new CarView("CarSim 3.0");

        view.addUIElement(drawPanel);
        view.addUIElement(loggerPanel);
        view.startNewRow();
        view.addUIElement(gasPanel);
        view.startNewRow();
        view.addUIElement(controlPanel);


        GasController gasController = new GasController(gasPanel, m);
        ControllPanelController cPC = new ControllPanelController(controlPanel, m);
    }

    private static void makeView2(IModel m) {
        List<JPanel> panels = new ArrayList<>();

        GasPanel gasPanel = new GasPanel();
        ControlPanel controlPanel = new ControlPanel(800);

        CarView view = new CarView("Control 2.0");

        view.addUIElement(gasPanel);
        view.addUIElement(controlPanel);


        GasController gasController = new GasController(gasPanel, m);
        ControllPanelController cPC = new ControllPanelController(controlPanel, m);
    }


}
