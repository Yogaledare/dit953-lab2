package Model;

/**
 * Interface Model.Model.ITrim is used to trim a car,
 * findSpeedFactor should be multiplied with a trim factor.
 */
public interface ITrim extends ICarable {
    ITrim move();
    ITrim turnAround();
    ITrim turnRight();
    ITrim turnLeft();
    ITrim startEngine();
    ITrim stopEngine();
    ITrim gas(double amount);
    ITrim brake(double amount);
}
