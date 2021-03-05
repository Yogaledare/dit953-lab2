package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;

import Model.*;
import Observer.EventSource;
import Observer.EventObserver;


// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements EventObserver<IPaintable> {
    private final Map<String, BufferedImage> images = new HashMap<>();
    private final List<IPaintable> paintables = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, EventSource<IPaintable> source) {
        source.addSubscriber(this);
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
    public void actOnPublish(Collection<? extends IPaintable> paintables) {
        setList(paintables);
        repaint();
    }

    public void setList(Collection<? extends IPaintable> paintables){
        this.paintables.clear();
        this.paintables.addAll(paintables);
    }

    // This method is called each time the panel updates/refreshes/repaints itself

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IPaintable paintable : paintables) {
            Vector2D pos = paintable.getPosition();
            BufferedImage image = get(paintable.getName());
            g.drawImage(image, (int)pos.getX(), (int)pos.getY(), null);
        }
    }
}
