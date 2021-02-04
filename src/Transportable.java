/**
 * Transportable interface enables an object to be transported, i.e. loaded into a container.
 */
public interface Transportable {
    void setDirection(Vector2D direction);
    Vector2D getDirection();
    void setPosition(Vector2D position);
    Vector2D getPosition();
    double getWidth();
    double getLength();
}
