package View;

import Model.*;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
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

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Gas");
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


    JLabel car1_speed = new JLabel("Car 1: ");


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
//        this.setLayout(new GridBagLayout());
//        JPanel holder = new JPanel();
//        holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));


//        this.add(testTarget);

//        this.add(testTarget);
//        this.add(drawPanel);

        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        JButton test_1 = new JButton("test_1");

//        JPanel gasPanelHolder = new JPanel();
//        gasPanelHolder.setLayout(new BoxLayout(gasPanelHolder, BoxLayout.X_AXIS));
//        gasPanelHolder.setAlignmentX(Component.LEFT_ALIGNMENT);




        JPanel startStop = new JPanel();
//        startStop.setLayout(new BoxLayout(startStop, BoxLayout.X_AXIS));

        JPanel allCarControls = new JPanel();
//        allCarControls.setLayout(new BoxLayout(allCarControls, BoxLayout.X_AXIS));


        SpinnerModel spinnerModel = new SpinnerNumberModel(
                0,       //initial value
                0,    //min
                100,  //max
                1      //step
                );
        gasSpinner = new JSpinner(spinnerModel);
        Dimension d = gasSpinner.getPreferredSize();
        d.width = 130;
        gasSpinner.setMinimumSize(d);
        gasSpinner.setMaximumSize(d);
//        Dimension s = gasLabel.getPreferredSize();
//        s.width = d.width;
//        gasLabel.setMinimumSize(s);
//        gasLabel.setMaximumSize(s);
//        Dimension a = gasPanel.getPreferredSize();
//        a.width = d.width;
//        a.height = d.height + s.height;
//        gasPanel.setMinimumSize(a);
//        gasPanel.setMaximumSize(a);


        gasPanel.setLayout(new BoxLayout(gasPanel, BoxLayout.Y_AXIS));
//        gasPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        gasPanel.setPreferredSize(new Dimension(10,10));
//        Box tempBox = Box.createHorizontalBox();
//        tempBox.add(gasLabel, BorderLayout.PAGE_START);
//        tempBox.add(Box.createHorizontalGlue());
        gasPanel.add(gasLabel);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasPanel.setBackground(Color.gray);
//        Dimension d = gasPanel.getPreferredSize();
//        d.width = 100;
//        gasSpinner.setPreferredSize(d);
//        gasPanel.add(Box.createVerticalGlue());




//        this.add(gasPanel, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,0,0,0), 0,0));
//        gasPanel.setPreferredSize(new Dimension(100, 100));



//        gasPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        test_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        gasPanelHolder.add(Box.createHorizontalGlue());
//        box1.add(test_1);

//        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
//        controlPanel.add(brakeButton, 3);
//        controlPanel.add(turboOffButton, 4);
//        controlPanel.add(lowerBedButton, 5);
//        controlPanel.add(testButton, 6);
//        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
//        controlPanel.setPreferredSize(new Dimension(200, 200));


        controlPanel.setBackground(Color.CYAN);

//        box2.add(controlPanel);

//        box2.add(Box.createHorizontalGlue());

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
//        startButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        startButton.setPreferredSize(new Dimension(X/5-15,200));
//        box3.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
//        stopButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
//        stopButton.setPreferredSize(new Dimension(X/5-15,200));
//        box3.add(stopButton);

//        box1.setAlignmentX(Component.LEFT_ALIGNMENT);
//        box2.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        box3.setAlignmentX(Component.LEFT_ALIGNMENT);
//        box3.add(Box.createHorizontalGlue());



//        this.add(holder);


//        gasPanelHolder.add(Box.createHorizontalGlue());
//        allCarControls.add(Box.createHorizontalGlue());
//        startStop.add(Box.createHorizontalGlue());

        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createHorizontalBox();
        Box box4 = Box.createHorizontalBox();

        JComponent testComponent = new JSlider();

        box1.setBackground(Color.red);
        box2.setBackground(Color.orange);
        box3.setBackground(Color.yellow);

        box1.add(drawPanel);
//        box1.add(Box.createHorizontalGlue());
        box1.add(startButton);
        box1.add(Box.createHorizontalGlue());
        box2.add(stopButton);
        box2.add(gasButton);
        box2.add(brakeButton);
        box2.add(turboOnButton);
        box2.add(turboOffButton);
        box2.add(Box.createHorizontalGlue());
        box3.add(liftBedButton);
        box3.add(lowerBedButton);
        box3.add(Box.createHorizontalGlue());
        box4.add(gasPanel);
        box4.add(Box.createHorizontalGlue());


        this.add(box1);
        this.add(box2);
        this.add(box3);
        this.add(box4);
        this.add(testComponent);
//        this.add(Box.createVerticalGlue());
//        this.add(Box.createVerticalGlue());

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