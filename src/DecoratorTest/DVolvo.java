package DecoratorTest;

import Model.*;

import java.awt.*;

public class DVolvo extends BaseDecorator {

    private final static double trimFactor = 1.25;

    DVolvo(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn) {
        super(position, direction, currentSpeed, engineOn,
                100, 2, 5, "Volvo240", Color.black, 4);
    }



}
