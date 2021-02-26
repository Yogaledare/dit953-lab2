package Controller;

import Model.Car;
import Model.IModel;
import Model.Saab95;
import Model.Vector2D;
import View.IAddRemovePanel;

public class AddRemoveContoller {
    public AddRemoveContoller(IAddRemovePanel panel) {
        Car saab95 = new Saab95(2,3);
        saab95.setPosition(new Vector2D(500, 0));
        panel.addCarButtonActionListener(e -> System.out.println("Car added"));
        panel.removeCarButtonActionListener(e -> System.out.println("Car removed"));

    }
}
