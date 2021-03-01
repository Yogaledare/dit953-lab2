package Model;

import java.awt.*;

/**
 * The car component representing car features
 */
public abstract class Car extends Vehicle implements ITransportable {
    /**
     * Car model
     */
    private final String modelName;

    /**
     * Color of car
     */
    private Color color;

    /**
     * Number of doors the car has
     */
    private final int nrDoors;

    /**
     * Creates a representation of a car
     * @param enginePower How powerful the car is
     * @param width How wide the car is
     * @param length How long the car is
     * @param modelName The name of the car
     * @param color The color of the car
     * @param nrDoors How many doors the car has
     */
    public Car(double enginePower, double width, double length, String modelName, Color color, int nrDoors){
        super(enginePower, width, length);
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
//        vehicle.setPosition(new Model.Model.Vector2D(0, 0));
    }
    /**
     * Creates a representation of a car
     * @param enginePower How powerful the car is
     * @param width How wide the car is
     * @param length How long the car is
     * @param modelName The name of the car
     * @param color The color of the car
     * @param nrDoors How many doors the car has
     * @param pos Where to place the car
     */
    public Car(double enginePower, double width, double length, String modelName, Color color, int nrDoors, Vector2D pos){
        super(enginePower, width, length);
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        setPosition(pos);
    }

    /**
     * Returns the number of doors of the car.
     * @return the number of doors of the car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the color of the car.
     * @return the color of the car.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of car.
     * @param clr the new color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Returns the modelName of the car.
     * @return the modelName of the car
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Returns number of doors on the car
     * @return number of doors on the car
     */
    public int getNoOfDoors() { return this.nrDoors; }


    @Override
    protected double findSpeedFactor() {
        return 0;
    }




/*    @Override
    public void getCarried(Model.Vector2D position, Model.Vector2D direction) {
        this.setPosition(position);
        this.getDirection(direction);

    }*/
}

