package Model.CompositeTest;

import Model.ITransporter;
import Model.Vector2D;

/**
 * Transportable interface enables an object to be transported, i.e. loaded into a container.
 */
public interface ITransportableC {
    double getWidth();
    double getLength();
    Vector2D getPosition();
    //    void getCarried(Vector2D position, Vector2D direction);
    Model.ITransportable follow(ITransporter<Model.ITransportable> transporter);

}
