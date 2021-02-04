/**
 * Interface for a movable object.
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

//    double findSpeedFactor();

    void gas(double amount);

    void brake(double amount);

    boolean isMoving();

    void startEngine();
    void stopEngine();

//    double getSpeed();
}
