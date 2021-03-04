package View;
import Model.ICarable;
import Model.Vector2D;

public class PaintableWrapper implements IPaintable{

    private final ICarable car;

    public PaintableWrapper(ICarable car){

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
