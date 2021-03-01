package Model;

/**
 * Transportable interface enables an object to be transported, i.e. loaded into a container.
 */
public interface ITransportable {

    Vector2D getDirection();
    Vector2D getPosition();

//    void setDirection(Vector2D direction);
//    void setPosition(Vector2D position);

    void getCarried(Vector2D position, Vector2D direction);

    double getWidth();
    double getLength();
}
