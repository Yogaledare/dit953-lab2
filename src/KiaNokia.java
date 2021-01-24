import java.awt.*;

public class KiaNokia extends Car {

    // This car has no turbo or trim.

    public KiaNokia() { super("KiaNokia", Color.BLACK, 60, 4); }

    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01;
    }

}
