import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240() {
        super("Volvo240", Color.black, 100, 4);
    }

    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}




/*    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + findSpeedFactor() * amount, getEnginePower()));
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - findSpeedFactor() * amount, 0));
    }*/



/*    public Volvo240(){
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        stopEngine();
    }*/
