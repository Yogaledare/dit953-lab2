package View;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import Model.ObserverHandler;
import Model.PaintObserver;
import Model.Vector2D;



// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements PaintObserver {


    private final Map<String, BufferedImage> images = new HashMap<>();
    private final List<IPaintable> paintables = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ObserverHandler handler) {
        handler.addSubscriber(this);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setMinimumSize(new Dimension(x, y));
        this.setMaximumSize(new Dimension(x, y));
        this.setBackground(Color.green);
        bindCars();
    }

    private void bindCars() {
        bind("Saab95", "../pics/Saab95.jpg");
        bind("Volvo240", "../pics/Volvo240.jpg");
        bind("Scania", "../pics/Scania.jpg");
    }

    public void bind(String name, String imageFileName) {
        try {
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(imageFileName));
            images.put(name, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage get(String name) {
        return images.get(name);
    }

    @Override
    public void actOnPublish(List<? extends IPaintable> paintables) {
        setList(paintables);
        repaint();
    }

    public void setList(List<? extends IPaintable> paintables){
        this.paintables.clear();
        this.paintables.addAll(paintables);
    }

    /*
    public void paintCars(List<? extends View.IPaintable> paintables){
        Graphics graphics = getGraphics();
        super.paintComponent(graphics);

        for (View.IPaintable paintable : paintables) {
            Model.Model.Vector2D pos = paintable.getPosition();
            BufferedImage image = images.get(paintable.getModelName());
            graphics.drawImage(image, (int)pos.getX(), (int)pos.getY(), null);
        }
    }
     */

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IPaintable paintable : paintables) {
            Vector2D pos = paintable.getPosition();
            BufferedImage image = get(paintable.getModelName());
            g.drawImage(image, (int)pos.getX(), (int)pos.getY(), null);
        }
    }
}
