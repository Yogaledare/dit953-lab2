package Model;

/**
 * Interface for a movable object. anything wheel-unit that can move.
 */
public interface IVehicle {


    /**
     * Moves the object.
     */
    IVehicle move();


    /**
     * Turns the movable object 180 degree.
     */
    IVehicle turnAround();

    /**
     * Turns the object left.
     */
    IVehicle turnLeft();

    /**
     * Turns the object right.
     */
    IVehicle turnRight();


    /**
     * Gas amount, between [0,1]
     * @param amount how much to accelerate.
     */
    IVehicle gas(double amount);

    /**
     * break amount, between [0,1]
     * @param amount how much to deaccelerate
     */
    IVehicle brake(double amount);

    /**
     * If speed > 0 then its moving.
     * @return true if currentspeed > 0
     */
    boolean isMoving();

    /**
     * Start engine.
     */
    IVehicle startEngine();

    /**
     * Stop engine.
     */
    IVehicle stopEngine();

    /**
     * Returns current position
     */
    Vector2D getPosition();


    Vector2D getDirection();
    /**
     *
     * @return
     */
    String getModelName();

    /**
     *
     * @return
     */
    double getCurrentSpeed();


}
