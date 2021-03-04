package Model;

/**
 * Transportable interface enables an object to be transported, i.e. loaded into a container.
 */
public interface ITransportable {

    double getWidth();
    double getLength();

    Vector2D getPosition();

    void getCarried(Vector2D position, Vector2D direction);

}




//    Vector2D getDirection();

//    void setDirection(Vector2D direction);
//    void setPosition(Vector2D position);

