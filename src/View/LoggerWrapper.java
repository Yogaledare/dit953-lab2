package View;

import Model.Car;
import Model.IMovable;

public class LoggerWrapper implements ILoggable {
//    private final double speed;
//    private final String name;

    private final IMovable car;

    public LoggerWrapper(IMovable car){

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
