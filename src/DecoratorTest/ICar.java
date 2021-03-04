package DecoratorTest;

import Model.IRampVehicle;
import Model.ITurboVehicle;
import Model.Vector2D;

interface ICar {
    // Movement, kanske inte behöver vara här
    ICar move();
    ICar turnAround();
    ICar turnLeft();
    ICar turnRight();
    ICar gas(double amount);
    ICar brake(double amount);
    ICar startEngine();
    ICar stopEngine();
    double findSpeedFactor();

    // Ramp
    ICar raise(double amount);
    ICar lower(double amount);

    // Turbo
    ICar turboOn();
    ICar turboOff();

    // Misc
    boolean isEngineOn();
    boolean isMoving();
    Vector2D getPosition();
    Vector2D getDirection();
    String getModelName();
    double getCurrentSpeed();

}
