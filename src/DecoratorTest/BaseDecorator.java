package DecoratorTest;

import Model.Vector2D;

abstract class BaseDecorator implements ICar {
    private final ICar otherCar;

    BaseDecorator(ICar iCar){
        otherCar = iCar;
    }

    @Override
    public ICar move() {
        return otherCar.move();
    }

    @Override
    public ICar turnAround() {
        return otherCar.turnAround();
    }

    @Override
    public ICar turnLeft() {
        return otherCar.turnLeft();
    }

    @Override
    public ICar turnRight() {
        return otherCar.turnRight();
    }

    @Override
    public ICar gas(double amount) {
        return otherCar.gas(amount);
    }

    @Override
    public ICar brake(double amount) {
        return otherCar.brake(amount);
    }

    @Override
    public ICar startEngine() {
        return otherCar.startEngine();
    }

    @Override
    public ICar stopEngine() {
        return otherCar.stopEngine();
    }

    @Override
    public ICar raise(double amount) {
        return otherCar.raise(amount);
    }

    @Override
    public ICar lower(double amount) {
        return otherCar.lower(amount);
    }

    @Override
    public ICar turboOn() {
        return otherCar.turboOn();
    }

    @Override
    public ICar turboOff() {
        return otherCar.turboOff();
    }

    @Override
    public boolean isMoving() {
        return otherCar.isMoving();
    }

    @Override
    public Vector2D getPosition() {
        return otherCar.getPosition();
    }

    @Override
    public Vector2D getDirection() {
        return otherCar.getDirection();
    }

    @Override
    public String getModelName() {
        return otherCar.getModelName();
    }

    @Override
    public double getCurrentSpeed() {
        return otherCar.getCurrentSpeed();
    }
}
