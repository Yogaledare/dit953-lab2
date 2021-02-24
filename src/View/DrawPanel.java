package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    private final Map<String, BufferedImage> images = new HashMap<>();
    private final List<IPaintable> paintables = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        bindCars();
    }

    private void bindCars() {
        bind("Model.Saab95", "pics/Saab95.jpg");
        bind("Model.Volvo240", "pics/Volvo240.jpg");
        bind("Model.Scania", "pics/Scania.jpg");
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


    public void setList(List<? extends IPaintable> paintables){
        this.paintables.clear();
        this.paintables.addAll(paintables);
    }

    /*
    public void paintCars(List<? extends Model.IPaintable> paintables){
        Graphics graphics = getGraphics();
        super.paintComponent(graphics);

        for (Model.IPaintable paintable : paintables) {
            Model.Vector2D pos = paintable.getPosition();
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
            BufferedImage image = images.get(paintable.getModelName());
            g.drawImage(image, (int)pos.getX(), (int)pos.getY(), null);
        }
    }



}
