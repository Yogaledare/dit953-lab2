package Controller;

import View.IControlPanel;
import Model.IModel;

public class ControlPanelController {
    public ControlPanelController(IControlPanel panel, IModel model){
        panel.setStartButtonActionListener(e -> model.startEngine());
        panel.setStopButtonActionListener(e -> model.stopEngine());
        panel.setTurboOnButtonActionListener(e -> model.setTurboOn());
        panel.setTurboOffButtonActionListener(e -> model.setTurboOff());
        panel.setLiftBedButtonActionListener(e -> model.raise());
        panel.setLowerBedButtonActionListener(e -> model.lower());
    }
}
