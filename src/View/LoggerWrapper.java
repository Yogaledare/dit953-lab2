package View;

import Model.IVehicle;

public class LoggerWrapper implements ILoggable {
//    private final double speed;
//    private final String name;

    private final IVehicle car;

    public LoggerWrapper(IVehicle car){

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
