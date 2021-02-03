public class Ramp {
    /**
     * Current angle of the ramp (70 == raised, 0 == lowered)
     */
    private final double maxAngle;
    private double rampAngle;
    private double rampSpeed;

    public Ramp(double maxAngle, double speed){
        this.maxAngle = maxAngle;
        rampAngle = maxAngle;
        rampSpeed = speed;
    }

    public void lower(){
        while (rampAngle > 0) {
            rampAngle = Vector2D.clamp(rampAngle -= rampSpeed, 0, maxAngle);
        }
    }

    public void raise(){
        while (rampAngle < 70) {
            rampAngle = Vector2D.clamp(rampAngle += rampSpeed, 0, maxAngle);
        }
    }

    public boolean fullyRaised(){
        return rampAngle == 70;
    }

    public boolean fullyLowered(){
        return rampAngle == 0;
    }
}
