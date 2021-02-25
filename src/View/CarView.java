package View;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame implements ICarView, PaintObserver {
    private static final int X = 800;
    private static final int Y = 800;

    private List<JPanel> panels;


    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton testBigButton = new JButton("test 2");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Model.Model.Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton testButton = new JButton("Testbutton");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, ObserverHandler observerHandler){
        initComponents(framename);
        observerHandler.addSubscriber(this);
    }

    @Override
    public void actOnPublish(List<? extends IPaintable> paintables) {
        //drawPanel.paintCars(paintables);
        drawPanel.setList(paintables);
        drawPanel.repaint();
    }

    // Sets everything in place and fits everything

    private void initComponents(String title) {

        this.setTitle(title);
//        this.setPreferredSize(new Dimension(X,Y));
//        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));

        panels.forEach(this::add);
/*
        testBigButton.setBackground(Color.red);
        testBigButton.setForeground(Color.black);
        testBigButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(testBigButton);
*/

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void setGasButtonActionListener(ActionListener listener) {
        gasButton.addActionListener(listener);
    }

    @Override
    public void setBrakeButtonActionListener(ActionListener listener) {
        brakeButton.addActionListener(listener);
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
    public void setLowerBedButtonActionListener(ActionListener listener) {
        lowerBedButton.addActionListener(listener);
    }

    @Override
    public void setSpinnerChangeListener(ChangeListener listener) {
        gasSpinner.addChangeListener(listener);
    }
}