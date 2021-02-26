package View;
import Model.EventHandler;
import Model.EventObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class AddRemovePanel extends JPanel implements IAddRemovePanel {
    JButton addButton = new JButton("Add Car");
    JButton removeButton = new JButton("Remove Car");
    JPanel addRemovePanel = new JPanel();


    public AddRemovePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        addRemovePanel.setLayout(new BoxLayout(addRemovePanel, BoxLayout.PAGE_AXIS));
        this.add(addRemovePanel);
        this.add(Box.createHorizontalStrut(5));
        this.add(addButton, BorderLayout.LINE_START);
        this.add(removeButton, BorderLayout.LINE_END);
    }

    @Override
    public void addCarButtonActionListener(ActionListener listener) { addButton.addActionListener(listener);}

    @Override
    public void removeCarButtonActionListener(ActionListener listener) { removeButton.addActionListener(listener); }


}
