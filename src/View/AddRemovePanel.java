package View;

import Model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



// This panel represent the animated part of the view with the car images.

public class AddRemovePanel extends JPanel implements IAddRemovePanel, PaintObserver {
    JButton addButton = new JButton("Add Car");
    JButton removeButton = new JButton("Remove Car");
    JPanel addRemovePanel = new JPanel();

    // Initializes the panel and reads the images
    public AddRemovePanel(ObserverHandler observerHandler) {
        observerHandler.addSubscriber(this);
    }

    @Override
    public void actOnPublish(List<? extends IPaintable> paintables) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void initComponents() {
        addRemovePanel.setLayout(new GridLayout(2,1));
        addRemovePanel.add(addButton, 0);
        addRemovePanel.add(removeButton, 1);
        this.setVisible(true);
    }

    @Override
    public void setAddCarButtonActionListener(ActionListener listener) { addButton.addActionListener(listener);}

    @Override
    public void setRemoveCarButtonActionListener(ActionListener listener) { removeButton.addActionListener(listener); }
}
