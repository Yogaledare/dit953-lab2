package View;
import Model.IAddRemovePanel;
import Model.PaintObserver;
import Model.ObserverHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

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
        repaint();
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