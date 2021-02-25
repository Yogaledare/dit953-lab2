package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements IControlPanel {
//    JButton gasButton = new JButton("Gas");
//    JButton brakeButton = new JButton("Brake");

    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Model.Model.Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public ControlPanel(int X){
        this.setLayout(new GridLayout(2,4));
//        this.add(gasButton, 0);
        this.add(turboOnButton, 0);
        this.add(liftBedButton, 1);
//        this.add(brakeButton, 3);
        this.add(turboOffButton, 2);
        this.add(lowerBedButton, 3);

        this.setPreferredSize(new Dimension((X/2)+4, 200));
        this.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);
    }

    @Override
    public void setStartButtonActionListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    @Override
    public void setStopButtonActionListener(ActionListener listener) {
        stopButton.addActionListener(listener);
    }

    @Override
    public void setTurboOnButtonActionListener(ActionListener listener) {
        turboOnButton.addActionListener(listener);
    }

    @Override
    public void setTurboOffButtonActionListener(ActionListener listener) {
        turboOffButton.addActionListener(listener);
    }

    @Override
    public void setLiftBedButtonActionListener(ActionListener listener) {
        liftBedButton.addActionListener(listener);
    }

    @Override
    public void setLowerBedButtonActionListener(ActionListener listener){
        lowerBedButton.addActionListener(listener);
    }
}