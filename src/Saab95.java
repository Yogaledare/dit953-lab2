import java.awt.*;

/**
 * A class representing a Saab95 car.
 */

public class Saab95 implements Movable, Transportable, AuxTurbo{

    /**
     * Flag to indicate if turbo is on or not.
     */
    private boolean turboOn;
    private final Car car;

    /**
     * Constructs a Saab95 object with (hardcoded) presets for modelName, color, enginePower and nrDoors. Initializes
     * turboOn to false.
     */
    public Saab95(double width, double length) {
        this.car = new Car(100, width, length, "Volvo240", Color.black, 4);
        turboOn = false;
    }

    /**
     * Sets turboOn to true.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets turboOn to false.
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Returns the value of turboOn.
     * @return the value of turboOn
     */
    public boolean getTurboOn() {
        return turboOn;
    }

    /**
     * Returns the turbo factor of the Saab95.
     * @return the turbo factor of the Saab95
     */
    private double findTurboFactor() {
        if (turboOn) return 1.3;
        return 1;
    }

    /**
     * Returns the speed factor of the Saab95.
     * @return the speed factor of the Saab95
     */
    private double findSpeedFactor() {
        return car.getEnginePower() * 0.01 * findTurboFactor();
    }

    /**
     * Number of doors
     * @return returns numbers of doors the car have.
     */
    public int getNoOfDoors() {
        return car.getNoOfDoors();
    }

    /**
     * Current speed of Saab 95
     * @return current speed.
     */
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    /**
     * Engine power, relates to max speed.
     * @return get the enginepower. 
     */
    public double getEnginePower() {
        return car.getEnginePower();
    }

    /**
     * Moves the truck in its current direction by length = current speed.
     */
    @Override
    public void move() {
        car.move();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount) {
        car.brake(amount, findSpeedFactor());
    }

    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    /**
     * Starts the car by setting its speed to 0.1.
     */
    @Override
    public void startEngine() {
        car.startEngine();
    }

    /**
     * Stops the car by setting its speed to 0.
     */
    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    /**
     * Returns the width of the car.
     * @return the width of the car.
     */
    @Override
    public double getWidth() {
        return car.getWidth();
    }

    /**
     * Returns the length of the car. 
     * @return the length of the car. 
     */
    @Override
    public double getLength() {
        return car.getLength();
    }

    /**
     * Sets the position of the car. 
     * @param position the new position of the car. 
     */
    @Override
    public void setPosition(Vector2D position) {
        car.setPosition(position);
    }

    /**
     * Returns the position of the car. 
     * @return the position of the car. 
     */
    @Override
    public Vector2D getPosition() {
        return car.getPosition();
    }
}




/*    @Override
    public void incrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() + findSpeedFactor() * amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        setCurrentSpeed(getCurrentSpeed() - findSpeedFactor() * amount);
    }*/

/*    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
	    turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }*/



/*    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }*/
