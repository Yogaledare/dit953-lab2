//package DecoratorTest;
//
//import Model.*;
//
//import java.awt.*;
//
//public class DVolvo extends BasicCar {
//
//    private final static double trimFactor = 1.25;
//
//    private final ICar iCar;
//    /*
//    DVolvo(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn) {
//        super(position, direction, currentSpeed, engineOn,
//                100, 2, 5, "Volvo240", Color.black, 4);
//    }
//
//    DVolvo(ICar iCar){
//        super(iCar.getPosition(), iCar.getDirection(), iCar.getCurrentSpeed(), iCar.isEngineOn(),
//                100, 2, 5, "Volvo240", Color.black, 4);
//        this.iCar = iCar;
//    }
//    private DVolvo(Vector2D position, Vector2D direction, double currentSpeed, boolean engineOn, ICar ref){
//        super(position, direction, currentSpeed, engineOn,
//                100, 2, 5, "Volvo240", Color.black, 4);
//        iCar = ref;
//    }
//    */
//    private DVolvo(ICar change, ICar ref){
//        super(change.getPosition(), change.getDirection(), change.getCurrentSpeed(), change.isEngineOn(),
//                100, 2, 5, "Volvo240", Color.black, 4);
//        iCar = ref;
//    }
//
//
//
//    @Override
//    public ICar move() {
//        return new DVolvo(super.move(), iCar);
//    }
//    @Override
//    public ICar gas(double amount){
//        return new DVolvo(super.gas(amount), iCar);
//    }
//    @Override
//    public ICar brake(double amount){
//        return new DVolvo(super.brake(amount), iCar);
//    }
//    @Override
//    public ICar turnLeft(){
//        return new DVolvo(super.turnLeft(), iCar);
//    }
//    @Override
//    public ICar turnRight(){
//        return new DVolvo(super.turnRight(), iCar);
//    }
//    @Override
//    public ICar turnAround(){
//        return new DVolvo(super.turnAround(), iCar);
//    }
//    @Override
//    public ICar startEngine(){
//        return new DVolvo(super.startEngine(), iCar);
//    }
//    @Override
//    public ICar raise(double amount){
//        return new DVolvo(iCar.raise(amount), iCar);
//    }
//    @Override
//    public ICar lower(double amount){
//        return new DVolvo(iCar.lower(amount), iCar);
//    }
//    @Override
//    public ICar turboOn(){
//        return new DVolvo(iCar.turboOn(), iCar);
//    }
//    @Override
//    public ICar turboOff(){
//        return new DVolvo(iCar.turboOff(), iCar);
//    }
//    @Override
//    public double findSpeedFactor(){
//        return getEnginePower() * 0.01 * trimFactor * iCar.findSpeedFactor();
//    }
//
//}
