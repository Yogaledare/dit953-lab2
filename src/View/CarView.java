package View;

import javax.swing.*;
import java.awt.*;
import java.text.CompactNumberFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame {
//    private static int X;
//    private static int Y;

//    private List<JPanel> panels;


    private final List<List<Component>> UIElements = new ArrayList<>();

//    private List<Box> display = new ArrayList<>();

    //JButton testBigButton = new JButton("test 2");

    // Constructor
    public CarView(String frameName) {
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        startNewRow();
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        initComponents(frameName);

    }


    private void updateView() {
        for (List<Component> listOfElements : UIElements) {
            Box currentBox = Box.createHorizontalBox();
            for (Component UIElement : listOfElements) {
                currentBox.add(UIElement);
            }
            currentBox.add(Box.createHorizontalGlue());
            this.add(currentBox);
        }
        this.pack();
    }


    public void addUIElement(Component newElement) {
        UIElements.get(UIElements.size() - 1).add(newElement);
        updateView();
    }


    public void startNewRow() {
        UIElements.add(new ArrayList<>());

    }

    public void addUIRow() {
        startNewRow();
    }

}




//    public CarView(int x, int y, String frameName, List<JPanel> panels){
//        X = x;
//        Y = y;
//        this.panels = panels;
//        initComponents(frameName);
//    }

    /*
    @Override
    public void actOnPublish(List<? extends IPaintable> paintables) {
        //drawPanel.paintCars(paintables);
        drawPanel.setList(paintables);
        drawPanel.repaint();
    }
    */

    // Sets everything in place and fits everything
//    private void initComponents(String title) {
//
//        this.setTitle(title);
////        this.setPreferredSize(new Dimension(X,Y));
////        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
//
//        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));
//
//        panels.forEach(this::add);
/*
        testBigButton.setBackground(Color.red);
        testBigButton.setForeground(Color.black);
        testBigButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(testBigButton);
*/

    // Make the frame pack all it's components by respecting the sizes if possible.
//        this.pack();

    // Get the computer screen resolution
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        // Center the frame
//        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//        // Make the frame visible
//        this.setVisible(true);
//        // Make sure the frame exits when "x" is pressed
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
