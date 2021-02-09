import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private class DrawedCar{
        public Car carRef;
        public BufferedImage image;
        public Point point;

        public DrawedCar(Car ref, BufferedImage image){
            this.carRef = ref;
            this.image = image;
            this.point = new Point();
        }
    }

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;

    private List<DrawedCar> drawedCars = new ArrayList<>();
    // To keep track of a single cars position
    Point carPoint = new Point();

    // TODO: Make this general for all cars
    /*void moveit(int x, int y){
        carPoint.x = x;
        carPoint.y = y;
    }*/
    void moveit(Car carToMove){
        for(DrawedCar car : drawedCars){
            if(carToMove.equals(car.carRef) ){
                car.point.x = (int)carToMove.getPosition().getX();
                car.point.y = (int)carToMove.getPosition().getY();
            }
        }
    }

    public void connectCars(List<Car> cars){
        for(Car car : cars){
            try{
                drawedCars.add(new DrawedCar(
                        car,
                        ImageIO.read(DrawPanel.class.getResourceAsStream("pics/"+ car.getModelName() + ".jpg")))
                );
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
/*        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }*/

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(DrawedCar car : drawedCars){
            g.drawImage(car.image, car.point.x, car.point.y, null);
        }
        //g.drawImage(volvoImage, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
    }
}
