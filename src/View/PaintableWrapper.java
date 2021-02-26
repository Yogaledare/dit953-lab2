package View;
import Model.Car;
import Model.Vector2D;

public class PaintableWrapper implements IPaintable{

    private final String name;
    private final Vector2D pos;

    public PaintableWrapper(Car car){
        name = car.getModelName();
        pos = car.getPosition();
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public Vector2D getPosition(){
        return pos;
    }
}
