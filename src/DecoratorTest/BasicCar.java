//package DecoratorTest;
//
//import Model.Car;
//import Model.ITransportable;
//import Model.ITransporter;
//import Model.Vector2D;
//
//import java.awt.*;
//
//public class BasicCar extends Car implements ICar {
//
//    public BasicCar(Vector2D pos, Vector2D dir, double currentSpeed,
//    boolean engineOn, double enginePower, double width, double length,
//    String modelName, Color color, int nrDoors) {
//        super(pos, dir, currentSpeed, engineOn, enginePower, width, length, modelName, color, nrDoors);
//    }
//
//    BasicCar(BasicCar car){
//        super(car.getPosition(), car.getDirection(), car.getCurrentSpeed(),
//                car.isEngineOn(), car.getEnginePower(), car.getWidth(),
//                car.getLength(), car.getModelName(), car.getColor(),
//                car.getNrDoors());
//    }
//
//    @Override
//    public ICar move() {
//        Vector2D step = getDirection().multiplyByScalar(getCurrentSpeed());
//        Vector2D newPos = getPosition().plus(step);
//        return new BasicCar(newPos, getDirection(), getCurrentSpeed(), isEngineOn(), getEnginePower(),
//                getWidth(), getLength(), getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar turnAround() {
//        Vector2D dir = getDirection();
//        if (isEngineOn())
//            dir = getDirection().rotateCC(-Math.PI);
//        return new BasicCar(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getEnginePower(),
//                getWidth(), getLength(), getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar turnLeft() {
//        Vector2D dir = getDirection();
//        if (isEngineOn())
//            dir = getDirection().rotateCC(Math.PI / 2);
//        return new BasicCar(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getEnginePower(),
//                getWidth(), getLength(), getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar turnRight() {
//        Vector2D dir = getDirection();
//        if (isEngineOn())
//            dir = getDirection().rotateCC(-Math.PI / 2);
//        return new BasicCar(getPosition(), dir, getCurrentSpeed(), isEngineOn(), getEnginePower(),
//                getWidth(), getLength(), getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar gas(double amount) {
//        return new BasicCar(getPosition(), getDirection(),
//                getIncrementedSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
//                isEngineOn(), getEnginePower(), getWidth(), getLength(),
//                getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar brake(double amount) {
//        return new BasicCar(getPosition(), getDirection(),
//                getDecrementSpeed(Vector2D.clamp(amount, 0, 1), findSpeedFactor()),
//                isEngineOn(), getEnginePower(), getWidth(), getLength(),
//                getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar startEngine() {
//        double speed = 0;
//        if (!isEngineOn())
//            speed = 0.1;
//        return new BasicCar(getPosition(), getDirection(),
//                speed, true, getEnginePower(), getWidth(), getLength(),
//                getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar stopEngine() {
//        return new BasicCar(getPosition(), getDirection(),
//                0, false, getEnginePower(), getWidth(), getLength(),
//                getModelName(), getColor(), getNrDoors());
//    }
//
//    @Override
//    public ICar raise(double amount) {
//        return new BasicCar(this);
//    }
//
//    @Override
//    public ICar lower(double amount) {
//        return new BasicCar(this);
//    }
//
//    @Override
//    public ICar turboOn() {
//        return new BasicCar(this);
//    }
//
//    @Override
//    public ICar turboOff() {
//        return new BasicCar(this);
//    }
//
//    @Override
//    public double findSpeedFactor() {
//        return 1;
//    }
//
//}
//
