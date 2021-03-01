package Controller;

import Model.ICarView;
import Model.IModel;
import View.IControlPanel;
import View.IGasPanel;

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
//    member fields
    private IModel iModel;
    private int gasAmount;

/**
 * Constructor
  */
    public CarController(ICarView iCarView, IModel iModel) {
        this.iModel = iModel;
        this.gasAmount = 0;
        bindListeners(iCarView);
    }

//    bind listeners to buttons in view
    private void bindListeners(ICarView iCarView) {
        iCarView.setGasButtonActionListener(e -> iModel.gas(gasAmount));
        iCarView.setBrakeButtonActionListener(e -> iModel.brake(gasAmount));
        iCarView.setStartButtonActionListener(e -> iModel.startEngine());
        iCarView.setStopButtonActionListener(e -> iModel.stopEngine());
        iCarView.setTurboOnButtonActionListener(e -> iModel.setTurboOn());
        iCarView.setTurboOffButtonActionListener(e -> iModel.setTurboOff());
        iCarView.setLiftBedButtonActionListener(e -> iModel.raise());
        iCarView.setLowerBedButtonActionListener(e -> iModel.lower());
        iCarView.setSpinnerChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());
    }
}
