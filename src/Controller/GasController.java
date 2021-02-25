package Controller;

import Model.IModel;
import View.IGasPanel;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;

public class GasController {
    private int gasAmount;
    public GasController(IGasPanel panel, IModel model){
        panel.setSpinnerChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());
        panel.setGasButtonActionListener(e -> model.gas(gasAmount));
        panel.setBrakeButtonActionListener(e -> model.brake(gasAmount));
    }

}
