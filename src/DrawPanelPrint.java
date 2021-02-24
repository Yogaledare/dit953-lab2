import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanelPrint extends DrawPanel {
    Label label = new Label("<Bil> : < Hastighet>");

    // Initializes the panel and reads the images
    public DrawPanelPrint(int x, int y) {
        super(x,y);
        this.add(label);
    }


    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        label.paint(g);

        super.paintComponent(g);
    }
}
