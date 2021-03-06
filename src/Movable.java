/**
 * Interface for a movable object. anything wheel-unit that can move.
 */
public interface Movable {

    /**
     * Moves the object.
     */
    void move();

    /**
     * Turns the object left.
     */
    void turnLeft();

    /**
     * Turns the object right.
     */
    void turnRight();

    /**
     * Gas amount, between [0,1]
     * @param amount how much to accelerate.
     */
    void gas(double amount);

    /**
     * break amount, between [0,1]
     * @param amount how much to deaccelerate
     */
    void brake(double amount);

    /**
     * If speed > 0 then its moving.
     * @return true if currentspeed > 0
     */
    boolean isMoving();

    /**
     * Start engine.
     */
    void startEngine();

    /**
     * Stop engine.
     */
    void stopEngine();
}
