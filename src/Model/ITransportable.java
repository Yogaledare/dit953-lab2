package Model;

/**
 * Transportable interface enables an object to be transported, i.e. loaded into a container.
 */
public interface ITransportable {
    void setDirection(Vector2D direction);
    Vector2D getDirection();
    void setPosition(Vector2D position);
    Vector2D getPosition();

    void getCarried(Vector2D position, Vector2D direction);

    double getWidth();
    double getLength();
}
