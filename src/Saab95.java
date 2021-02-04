import java.awt.*;

/**
 * A class representing a Saab95 car.
 */

public class Saab95 implements Movable, Transportable/*Positionable, Storable, Movable, AuxTurbo */{

    /**
     * Flag to indicate if turbo is on or not.
     */
    private boolean turboOn;
    private Car car;

    /**
     * Constructs a Saab95 object by calling its parent constructor with (hardcoded) presets for modelName, color,
     * enginePower and nrDoors. Initializes turboOn to false.
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
    public double findTurboFactor() {
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
    public void gas(double amount, double speedFactor) {
        car.gas(amount, findSpeedFactor());
    }

    @Override
    public void brake(double amount, double speedFactor) {
        car.brake(amount, findSpeedFactor());
    }

    @Override
    public boolean isMoving() {
        return car.isMoving();
    }

    @Override
    public double getWidth() {
        return car.getWidth();
    }

    @Override
    public double getLength() {
        return car.getLength();
    }

    @Override
    public void setPosition(Vector2D position) {
        car.setPosition(position);
    }

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
