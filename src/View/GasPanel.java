package View;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class GasPanel extends JPanel implements IGasPanel {
    JSpinner gasSpinner;
    JLabel gasLabel = new JLabel("Gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JPanel gasSpinnerGroup = new JPanel();

    public GasPanel() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(
                0,       //initial value
                0,    //min
                100,  //max
                1      //step
        );
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.setMinimumSize(gasSpinner.getPreferredSize());
        gasSpinner.setMaximumSize(gasSpinner.getPreferredSize());


        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        gasSpinnerGroup.setLayout(new BoxLayout(gasSpinnerGroup, BoxLayout.PAGE_AXIS));
        gasSpinnerGroup.add(gasLabel);
        gasSpinnerGroup.add(gasSpinner);

        this.add(gasSpinnerGroup);
        this.add(Box.createHorizontalStrut(5));
        this.add(gasButton, BorderLayout.LINE_START);
        this.add(brakeButton, BorderLayout.LINE_END);

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
