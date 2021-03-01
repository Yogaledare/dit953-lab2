package Controller;

import Model.*;
import View.IAddRemovePanel;

public class AddRemoveContoller {
    public AddRemoveContoller(IAddRemovePanel panel, IModel model) {
        panel.addCarButtonActionListener(e -> model.addCar());
        panel.removeCarButtonActionListener(e -> model.removeCar());

    }
}
