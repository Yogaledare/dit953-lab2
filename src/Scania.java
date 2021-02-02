import java.awt.*;

public class Scania extends Vehicle implements AuxPlatform {

    private double platformAngle = 0.0;
    private final double PLATFORMSPEED = 1;


    public Scania() {
        this("Scania", Color.WHITE, 100, 2);
    }

    /**
     * Constructs a Vehicle object with the specified modelName, color, enginePower and nrDoors.
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

    public double getPlatformAngle() {
        return platformAngle;
    }

    /**
     * Raise loading platform.
     * returns true if platform is at load position.
     */
    public boolean raisePlatform() {
        if (getCurrentSpeed() == 0) {
            while (platformAngle < 70) {
                platformAngle = Vector2D.clamp(platformAngle += PLATFORMSPEED, 0, 70);
            }
        }
        return (platformAngle == 70);
    }

    /**
     * Lower loading platform to ground.
     * return true when platform is a 0 degree sensor.
     */
    public boolean lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            while (platformAngle > 0) {
                platformAngle = Vector2D.clamp(platformAngle -= PLATFORMSPEED, 0, 70);
            }
        }
        return (platformAngle == 0);
    }

    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if (getPlatformAngle() == 0) {
            super.startEngine();
        }
    }

}
