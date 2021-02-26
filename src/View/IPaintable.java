package View;

import Model.Vector2D;

/**
 * IPaintable is used to draw a car onto a soccer field (DrawPanel).
 *
 */
public interface IPaintable {
    Vector2D getPosition();
    String getName();
}
