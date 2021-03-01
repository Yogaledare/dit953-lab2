package View;

import Model.Car;

public class LoggerWrapper implements ILoggable {
//    private final double speed;
//    private final String name;

    private final Car car;

    public LoggerWrapper(Car car){

        this.car = car;
//        speed = car.getCurrentSpeed();
//        name = car.getModelName();
    }

    @Override
    public double getSpeed(){
        return car.getCurrentSpeed();
    }

    @Override
    public String getName(){
        return car.getModelName();
    }
}
