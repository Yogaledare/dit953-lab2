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

    void gas(double amount, double speedFactor);

    void brake(double amount, double speedFactor);

}
