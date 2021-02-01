import java.awt.*;

public class Scania extends Vehicle {

    private double platformAngle = 0.0;
    private final double platformSpeed = 70;


    public Scania() {
        this("Scania", Color.WHITE, 100, 2);
    }

    /**
     * Constructs a Car object with the specified modelYear, color, enginePower and nrDoors.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     *
     * @param modelName   the model name of the car
     * @param color       the color of the car
     * @param enginePower the engine power of the car
     * @param nrDoors     the number of doors of the car
     */
    public Scania(String modelName, Color color, double enginePower, int nrDoors) {
        super(modelName, color, enginePower, nrDoors);
    }

    public double getPlatformAngle(){
        return platformAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = Vector2D.clamp(platformAngle, 0, 70);
    }

    public double getPlatformSpeed() {
        return platformSpeed;
    }

    /**
     * Raises the angle of the loading platform of the truck
     */
    public void raisePlatform() {
        if (getCurrentSpeed() > 0) return;
        platformAngle = Vector2D.clamp(platformAngle += platformSpeed, 0, 70);
    }

    /**
     * Lowers the angle of the loading platform of the truck
     */
    public void lowerPlatform(){
        if(getCurrentSpeed() > 0) return;
        platformAngle = Vector2D.clamp(platformAngle -= platformSpeed, 0, 70);
    }

    @Override
    public void move() {
        if(platformAngle > 0) return;
        super.move();
    }

    @Override
    public double findSpeedFactor(){
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if (getPlatformAngle()==0) {
            super.startEngine();
        }
    }
}
