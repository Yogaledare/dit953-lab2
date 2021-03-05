package DecoratorTest;

public class DVolvo extends BaseFancyCar implements ICar {

    private final static double trimFactor = 1.25;
    /*
    DVolvo(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn) {
        super(position, direction, currentSpeed, engineOn,
                100, 2, 5, "Volvo240", Color.black, 4);
    }

    DVolvo(ICar iCar){
        super(iCar.getPosition(), iCar.getDirection(), iCar.getCurrentSpeed(), iCar.isEngineOn(),
                100, 2, 5, "Volvo240", Color.black, 4);
        this.iCar = iCar;
    }
    private DVolvo(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, ICar ref){
        super(position, direction, currentSpeed, engineOn,
                100, 2, 5, "Volvo240", Color.black, 4);
        iCar = ref;
    }

    private DVolvo(ICar change, ICar ref){
        super(change.getPosition(), change.getDirection(), change.getCurrentSpeed(), change.isEngineOn(),
                100, 2, 5, "Volvo240", Color.black, 4);
        iCar = ref;
    }
     */

    public DVolvo(ICar parent){
        super(parent);
    }

    @Override
    public ICar move() {
        return new DVolvo(parent.move());
    }
    @Override
    public ICar gas(double amount){
        return new DVolvo(parent.gas(amount));
    }
    @Override
    public ICar brake(double amount){
        return new DVolvo(parent.brake(amount));
    }
    @Override
    public ICar turnLeft(){
        return new DVolvo(parent.turnLeft());
    }
    @Override
    public ICar turnRight(){
        return new DVolvo(parent.turnRight());
    }
    @Override
    public ICar turnAround(){
        return new DVolvo(parent.turnAround());
    }
    @Override
    public ICar startEngine(){
        return new DVolvo(parent.startEngine());
    }

    @Override
    public ICar stopEngine() {
        return new DVolvo(parent.stopEngine());
    }

    @Override
    public ICar raise(double amount){
        return new DVolvo(parent.raise(amount));
    }
    @Override
    public ICar lower(double amount){
        return new DVolvo(parent.lower(amount));
    }
    @Override
    public ICar turboOn(){
        return new DVolvo(parent.turboOn());
    }
    @Override
    public ICar turboOff(){
        return new DVolvo(parent.turboOff());
    }

    @Override
    public boolean isEngineOn() {
        return parent.isEngineOn();
    }

    /*
    @Override
    public boolean isMoving() {
        return parent.isMoving();
    }

    @Override
    public Vector2D getPosition() {
        return parent.getPosition();
    }

    @Override
    public Vector2D getDirection() {
        return parent.getDirection();
    }

    @Override
    public String getModelName() {
        return parent.getModelName();
    }

    @Override
    public double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }
     */

    @Override
    public double findSpeedFactor(){
        return /*parent.getEnginePower() * 0.01 * trimFactor * iCar.findSpeedFactor() */ 0;
    }

}
