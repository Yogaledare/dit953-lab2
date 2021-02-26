package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements IControlPanel {
//    JButton gasButton = new JButton("Gas");
//    JButton brakeButton = new JButton("Brake");

    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");

    JButton liftBedButton = new JButton("Lift Bed");
    JButton lowerBedButton = new JButton("Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public ControlPanel(int X){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
//        this.add(gasButton);
        this.add(turboOnButton);
        this.add(Box.createHorizontalStrut(5));
        this.add(turboOffButton);
        this.add(Box.createHorizontalStrut(5));
//        this.add(brakeButton);
        this.add(liftBedButton);
        this.add(Box.createHorizontalStrut(5));
        this.add(lowerBedButton);
        this.add(Box.createHorizontalStrut(5));

//        this.setPreferredSize(new Dimension((X/2)+4, 200));
//        this.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
//        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);
        this.add(Box.createHorizontalStrut(5));


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
//        stopButton.setPreferredSize(new Dimension(X/5-15,200));
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
