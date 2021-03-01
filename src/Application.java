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
        List<IMovable> cars = new ArrayList<>();
        List<ITurbo> turbos = new ArrayList<>();
        // volvo
        IMovable volvo = CarFactory.createVolvo240(new Vector2D(0, 0));
        cars.add(volvo);

        // saab
        Saab95 saab95 = new Saab95(2,3);
        saab95.setPosition(new Vector2D(100, 0));
        cars.add(saab95);
        turbos.add(saab95);

        // scania
        IRamp scania = CarFactory.createScania(new Vector2D(200, 0));
        scania.lower(70);
        cars.add(scania);

        // Create MVC
        IModel model = new Model(cars, turbos);

        // First view is a full-blow MVC,
        // includes a car-world, controls, speed-log
        makeView1(model);

        // Second view includes car-controls only
        makeView2(model);

        // Start the timer
        model.startTimer();
    }

    private static void makeView1(IModel m) {

        // Class between model and view
        CarReciever reciever = new CarReciever(m.getModelUpdatedEvent());

        List<JPanel> panels = new ArrayList<>();

        // The panel where the cars are drawn
        DrawPanel drawPanel = new DrawPanel(800, 800-240, reciever.getPaintUpdatedEvent());

        // The panel for accelerating/decelerating the cars
        GasPanel gasPanel = new GasPanel();

        // The panel for controlling the cars
        ControlPanel controlPanel = new ControlPanel(800);

        // The Logger panel
        LoggerPanel loggerPanel = new LoggerPanel(reciever.getLoggUpdatedEvent());

        // The actual window
        CarView view = new CarView("CarSim 3.0");

        view.addUIElement(drawPanel);
        view.addUIElement(loggerPanel);
        view.startNewRow();
        view.addUIElement(controlPanel);
        view.startNewRow();
        view.addUIElement(gasPanel);

        // Controllers
        GasController gasController = new GasController(gasPanel, m);
        ControlPanelController cPC = new ControlPanelController(controlPanel, m);
    }

    private static void makeView2(IModel m) {
        List<JPanel> panels = new ArrayList<>();

        GasPanel gasPanel = new GasPanel();
        ControlPanel controlPanel = new ControlPanel(800);
        AddRemovePanel addRemovePanel = new AddRemovePanel();

        CarView view = new CarView("Control 2.0");

        view.addUIElement(gasPanel);
        view.addUIElement(addRemovePanel);
        view.addUIRow();
        view.addUIElement(controlPanel);

        GasController gasController = new GasController(gasPanel, m);
        ControlPanelController cPC = new ControlPanelController(controlPanel, m);
        AddRemoveContoller aRC = new AddRemoveContoller(addRemovePanel, m);
    }


}
