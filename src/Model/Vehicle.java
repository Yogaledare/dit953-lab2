package Model; /**
 * @author Niklas  Axelsson <gusaxenia@student.gu.se>
 * @author Carl    Stewart  <gusstewca@student.gu.se>
 * @author Marcus  Uppström <gusuppma@student.gu.se>
 * @version 0.1                 (current version number of program)
 */


/**
 * An abstract class representing a generic vehicle.
 */
public abstract class Vehicle implements IVehicle {

    /**
     * Current speed valid interval from 0 to Engine power
     */
    private double currentSpeed;

    /**
     * Engine power affects top speed, acceleration and deceleration
     */
    private final double enginePower;

    /**
     * Direction vector of the vehicle
     */
    private Vector2D direction;
    /**
     * Position vector of the vehicle
     */
    private Vector2D position;

    /**
     * width of the vehicle in meter.
     */
    private final double width;

    /**
     * length of the vehicle in meter.
     */
    private final double length;

    /**
     * State of the engine.
     */
//    private boolean engineOn;

    private IVehicleState state;

    /**
     * Constructs a vehicle object with the specified modelYear, color, enginePower and nrDoors.
     * The initial position (x, y) and direction (x, y) of the object is set to (0, 0) and (0, 1).
     *
     * @param enginePower the engine power of the vehicle
     */
    public Vehicle(double enginePower, double width, double length) {
        this.enginePower = enginePower;
        this.direction = new Vector2D(0, 1);
        this.position = new Vector2D(0, 0);
        this.width = width;
        this.length = length;
        this.state = new VehicleStateOff();
//        stopEngine();
    }


    /**
     * Starts the vehicle by setting currentSpeed to 0.1.
     * Change state of vehicle to engine on.
     */
    public void startEngine() {
        state.startEngine(this);
    }

    /**
     * Stops the vehicle by setting its speed to 0 and change state of vehicle to engine off.
     */
    public void stopEngine() {
        state.stopEngine(this);
    }

    /**
     * Increases the speed of the vehicle if it is in a state where the engine is on.
     * @param amount a value between 0 and 1 representing how much the gas is pressed.
     *               If a value outside [0,1] is given, the value is clamped to [0,1].
     */
    public void gas(double amount) {
        state.gas(this, amount);
    }


    /**
     * Decreases the speed of the vehicle if it is in moving state.
     * @param amount a value between 0 and 1 representing how much the brake is pressed.
     *               If a value outside [0,1] is given, the value is clamped to [0,1].
     */
    public void brake(double amount) {
        state.brake(this, amount);
    }

    /**
     * Turns the vehicle 90 degrees to the left.
     */
    public void turnLeft() {
        state.turnLeft(this);
    }

    /**
     * Turns the vehicle 90 degrees to the right.
     */
    public void turnRight() {
        state.turnRight(this);
    }

    /**
     * Turns the vehicle 180 degrees around.
     */
    public void turnAround() {
        state.turnLeft(this);
        state.turnLeft(this);
    }

    /**
     * Moves the vehicle in its current direction by length = currentSpeed.
     */
    public void move() {
        state.move(this);
    }



    public void respondToStateRequestMove() {
        Vector2D step = direction.multiplyByScalar(currentSpeed);
        position = position.plus(step);
    }

    public void respondToStateRequestTurnLeft() {
        direction = direction.rotateCC(Math.PI / 2);
    }

    public void respondToStateRequestTurnRight() {
        direction = direction.rotateCC(-Math.PI / 2);
    }

    public void respondToStateRequestTurnOnEngine() {
        state = new VehicleStateOnStopped();
    }

    public void respondToStateRequestTurnOffEngine() {
        this.currentSpeed = 0;
        state = new VehicleStateOff();
    }

    public void respondToStateRequestGas(double amount) {
        if (currentSpeed <= 0) {
            state = new VehicleStateOnMoving();
        }
        incrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor());
    }

    public void respondToStateRequestBrake(double amount) {
        decrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor());
        if (currentSpeed <= 0) {
            state = new VehicleStateOnStopped();
        }
    }



    /**
     * Increases the speed of the vehicle by the speed factor of the vehicle times a scale factor (amount).
     * The speed cannot exceed the enginePower of the vehicle.
     *
     * @param amount how much the speed should increase for every move.
     */
    private void incrementSpeed(double amount, double speedFactor) {
        currentSpeed = Vector2D.clamp(getCurrentSpeed() + speedFactor * amount, 0, enginePower);
    }

    /**
     * Decreases the speed of the vehicle by the speed factor of the vehicle times a scale factor (amount).
     * The speed can not go below 0.
     *
     * @param amount how much the speed should decrease for every move.
     */
    private void decrementSpeed(double amount, double speedFactor) {
        currentSpeed = Vector2D.clamp(getCurrentSpeed() - speedFactor * amount, 0, enginePower);
    }

    /**
     * Abstract method for calculating speed factor.
     *
     * @return the speed factor of the veheicle.
     */
    protected abstract double findSpeedFactor();




    /**
     * Returns the direction vector of the vehicle.
     *
     * @return the direction vector of the vehicle
     */
    public Vector2D getDirection() {
        return new Vector2D(direction);
    }

    /**
     * Returns x and y coordinate of Model.Model.Vehicle
     *
     * @return Model.Model.Vector2D(x, y)
     */
    public Vector2D getPosition() {
        return new Vector2D(position);
    }

    /**
     * Model.Model.Vehicle width
     *
     * @return width of the vehicle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Model.Model.Vehicle length
     *
     * @return length of the vehicle
     */
    public double getLength() {
        return length;
    }

    /**
     * Returns the enginePower of the vehicle.
     *
     * @return the enginePower of the vehicle
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Returns the current speed of the vehicle. The speed has a value between 0 and the enginePower of the vehicle.
     *
     * @return the current speed of the vehicle.
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Set position of vehicle
     *
     * @param position sets the coordinates of the vehicle.
     */

    public void setPosition(Vector2D position) {
        this.position = new Vector2D(position);
    }

     /**
     * Set current direction of the vehicle.
     *
     * @param direction set a direction of length 1 in Model.Model.Vector2D.
     */
    public void setDirection(Vector2D direction) {
        this.direction = new Vector2D(direction);
    }



}



//        incrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor());
// out text for debug only
//        System.out.println("Gas: " + amount );

/*
 *//**
 * returns true if vehicle is moving.
 *
 * @return true if vehicle is moving.
 *//*
    public boolean isMoving() {
        return currentSpeed > 0;
    }*/





/*    public void respondToStateRequestGasFromStopped(double amount) {
        state = new VehicleStateOnMoving();
        incrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor());
    }*/

