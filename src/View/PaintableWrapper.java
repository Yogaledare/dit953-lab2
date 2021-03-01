package View;
import Model.Car;
import Model.IMovable;
import Model.Vector2D;

public class PaintableWrapper implements IPaintable{

//    private final String name;
//    private final Vector2D pos;

    private IMovable car;

    public PaintableWrapper(IMovable car){

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
