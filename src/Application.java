import Controller.*;
import Model.*;
import View.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This is the main application.
 * hardcoded arguments exists in this class only(tm).
 */
public class Application {

    public static void main(String[] args) {
        Map<Integer, ICarable> allCars = new HashMap<>();
        Map<Integer,ITrim> cars = new HashMap<>();
        Map<Integer,ITurboVehicle> turbos = new HashMap<>();
        Map<Integer,IRampVehicle> ramps = new HashMap<>();

        Integer key = 0;
        // volvo
        ITrim volvo = CarFactory.createVolvo240(new Vector2D(0, 0), new Vector2D(0, 0), 0, false);
        cars.put(key, volvo);
        allCars.put(key++, volvo);

        // saab
        ITurboVehicle saab95 = CarFactory.createSaab95(new Vector2D(100, 0), new Vector2D(0, 0), 0, false, true);
        // cars.add(saab95);
        turbos.put(key, saab95);
        allCars.put(key++, saab95);

        // scania
        IRampVehicle scania = CarFactory.createScania(new Vector2D(200, 0), new Vector2D(0, 0), 0);
        scania.lower(70);
        // cars.add(scania);
        ramps.put(key, scania);
        allCars.put(key++, scania);

        // Create MVC
        IModel model = new Model(allCars,cars , turbos, ramps);

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
