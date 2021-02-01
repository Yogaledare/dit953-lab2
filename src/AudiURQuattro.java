/**
 * @author: Carl Stewart. <gustewca@student.gu.se>
 */

import java.awt.*;

public class AudiURQuattro extends Vehicle implements AuxTurbo, AuxTrim {
    private boolean turboOn = false;
    private final static double trimFactor = 1.25;

    public AudiURQuattro() {
        this("Audi Ur-Quattro", Color.RED, 300, 2 );
    }

    /**
     * Cars constructor
     *
     * @param modelName   Manufactures car model.
     * @param color       Color of the car
     * @param enginePower Engine power, relates to max speed
     * @param nrDoors     number of doors
     */
    public AudiURQuattro(String modelName, Color color, double enginePower, int nrDoors) {
        super(modelName, color, enginePower, nrDoors);
    }

    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    @Override
    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double findTurboFactor() {
        if (turboOn) return 1.3;
        return 1;
    }

    @Override
    public double findSpeedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
