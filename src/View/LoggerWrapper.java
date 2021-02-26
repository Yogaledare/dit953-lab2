package View;

import Model.Car;

public class LoggerWrapper implements ILoggable {
    private final double speed;
    private final String name;

    public LoggerWrapper(Car car){
        speed = car.getCurrentSpeed();
        name = car.getModelName();
    }

    @Override
    public double getSpeed(){
        return speed;
    }

    @Override
    public String getName(){
        return name;
    }
}
