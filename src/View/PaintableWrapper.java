package View;
import Model.Car;
import Model.Vector2D;

public class PaintableWrapper implements IPaintable{

//    private final String name;
//    private final Vector2D pos;

    private Car car;

    public PaintableWrapper(Car car){

        this.car = car;
//        name = car.getModelName();
//        pos = car.getPosition();
    }

    @Override
    public String getName(){
        return car.getModelName();
    }

    @Override
    public Vector2D getPosition(){
        return car.getPosition();
    }
}
