import java.awt.*;

public class Scania extends TransportTruck<Vehicle>  {


    // private LIFO<Vehicle> platform ;

    public Scania() {
        this("Scania", Color.WHITE, 100, 2, 20, new LIFO<Vehicle>(20, 3, 5));
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
    public Scania(String modelName, Color color, double enginePower, int nrDoors, double truckLength, LIFO<Vehicle> platform) {
        super(modelName, color, enginePower, nrDoors, truckLength, platform);

    }



    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void startEngine() {
        if (getRampAngle() == 0) {
            super.startEngine();
        }
    }

}
