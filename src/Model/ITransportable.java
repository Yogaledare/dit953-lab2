package Model;

/**
 * Transportable interface enables an object to be transported, i.e. loaded into a container.
 */
public interface ITransportable<T> {

    double getWidth();
    double getLength();

    Vector2D getPosition();

    T getCarriedTo(Vector2D position, Vector2D direction);

//    <K extends ITransportable> ITransportable follow(ITransporter<K> transporter);

}




//    Vector2D getDirection();

//    void setDirection(Vector2D direction);
//    void setPosition(Vector2D position);

