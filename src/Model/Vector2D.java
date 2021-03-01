package Model;

/**
 * A vector class representing immutable vectors in a 2D cartesian coordinate system.
 */
public class Vector2D {

    /**
     * x coordinate
     */
    private final double x;

    /**
     * y coordinate
     */
    private final double y;

    /**
     * Constructs a vector with coordinates (x, y).
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D vector2D){
        this.x = vector2D.x;
        this.y = vector2D.y;
    }

    /**
     * Returns a (new) sum vector resulting from adding the current vector and another vector (other).
     *
     * @param other the vector being added to the current vector
     * @return the sum vector
     */
    public Vector2D plus(Vector2D other) {
        double newX = this.x + other.x;
        double newY = this.y + other.y;
        return new Vector2D(newX, newY);
    }

    /**
     * Returns a (new) scaled vector resulting from multiplying the current vector by a scalar.
     *
     * @param scalar the scalar
     * @return the scaled vector
     */
    public Vector2D multiplyByScalar(double scalar) {
        double newX = this.x * scalar;
        double newY = this.y * scalar;
        return new Vector2D(newX, newY);
    }

    /**
     * Returns a (new) rotated vector resulting from rotating the current vector by an angle.
     *
     * @param angle the angle (in radians)
     * @return the rotated vector
     */
    public Vector2D rotateCC(double angle) {
        double newX = Math.cos(angle) * this.x - Math.sin(angle) * this.y;
        double newY = Math.sin(angle) * this.x + Math.cos(angle) * this.y;
        return new Vector2D(newX, newY);
    }

    @Override
    public String toString() {
        return "Model.Model.Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Returns the x coordinate
     *
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate
     *
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    public boolean equals(Vector2D other) {
        return x == other.x && y == other.y;
    }

    public double distanceTo(Vector2D other){
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    /**
     * Clamps a value d to the interval [min, max].
     * If d is outside the interval, either min or max is returned depending on if d is below min or above max.
     * If d is inside the interval, d is returned.
     *
     * @param d   the value to be clamped
     * @param min the min bound
     * @param max the max bound
     * @return the clamped value
     */
    public static double clamp(double d, double min, double max) {
        d = Math.max(d, min);
        return Math.min(d, max);
    }

}

