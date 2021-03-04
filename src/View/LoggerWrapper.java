package View;

import Model.ICarable;

public class LoggerWrapper implements ILoggable {
    private final ICarable car;

    public LoggerWrapper(ICarable car){
        this.car = car;
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
