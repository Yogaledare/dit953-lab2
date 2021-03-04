package Model;

public interface ICarable {


    /**
     * If speed > 0 then its moving.
     * @return true if currentspeed > 0
     */
    boolean isMoving();


    ICarable move();
    ICarable turnAround();
    ICarable turnRight();
    ICarable turnLeft();
    ICarable startEngine();
    ICarable stopEngine();
    ICarable gas(double amount);
    ICarable brake(double amount);


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
