package Model.Ramp;
import Model.Vector2D;
/**
 * Class representing a ramp that can be raised or lowered
 */

public class Ramp {

    /**
     * Maximum allowed angle of the ramp
     */
    private final double maxAngle;
    /**
     * Current angle of the ramp (70 == raised, 0 == lowered)
     */
    private double rampAngle;
    /**
     * How fast to move the ramp
     */
    private final double rampSpeed;

//    IRampState state = new RampLoweredState(this);

    public Ramp(Ramp r ) {
        this.rampSpeed = r.rampSpeed;
        this.rampAngle = r.rampAngle;
        this.maxAngle = r.maxAngle;
    }

    /**
     * Constructs a ramp that can be open/closed
     * @param maxAngle Maximum allowed angle of the ramp
     * @param speed How fast to move the ramp
     */
    public Ramp(double maxAngle, double speed){
        this.maxAngle = maxAngle;
        rampAngle = maxAngle;
        rampSpeed = speed;
    }

//    public void setState(IRampState state){
//        this.state = state;
//    }
//
//    public IRampState getState(){
//        return state;
//    }

    public void lower(double amount){
        rampAngle = Vector2D.clamp(rampAngle -= amount, 0, maxAngle);
    }

    public void raise(double amount){
        rampAngle = Vector2D.clamp(rampAngle += amount, 0, maxAngle);
    }

    /**
     * Lower the ramp fully
     */
    public void lowerFully(){
        while (rampAngle > 0) {
            rampAngle = Vector2D.clamp(rampAngle -= rampSpeed, 0, maxAngle);
        }
    }

    /**
     * Raise the ramp fully
     */
    public void raiseFully(){
        while (rampAngle < 70) {
            rampAngle = Vector2D.clamp(rampAngle += rampSpeed, 0, maxAngle);
        }
    }

    /**
     * @return Returns true if the ramp is raised all the way
     */
    public boolean isFullyRaised(){
        return rampAngle == 70;
    }

    /**
     * @return Returns true if the ramp is lowered all the way
     */
    public boolean isFullyLowered(){
        return rampAngle == 0;
    }
}
