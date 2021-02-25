package View;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class GasPanel extends JPanel implements IGasPanel {
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");

    public GasPanel() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(
                0,       //initial value
                0,    //min
                100,  //max
                1      //step
        );
        gasSpinner = new JSpinner(spinnerModel);

        this.setLayout(new BorderLayout());
        this.add(gasLabel, BorderLayout.PAGE_START);
        this.add(gasSpinner, BorderLayout.PAGE_END);
    }

    public void setGasSpinnerChangeListener(ChangeListener listener) {
        gasSpinner.addChangeListener(listener);
    }

    @Override
    public void setSpinnerChangeListener(ChangeListener listener) {
        gasSpinner.addChangeListener(listener);
    }

    @Override
    public void setGasButtonActionListener(ActionListener listener) {
        gasButton.addActionListener(listener);
    }

    @Override
    public void setBrakeButtonActionListener(ActionListener listener) {
        brakeButton.addActionListener(listener);
    }
}
