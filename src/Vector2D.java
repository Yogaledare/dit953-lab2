import java.util.Objects;

public class Vector2D {

    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
    public Vector2D minus(Vector2D other) {
        int newX = this.x - other.x;
        int newY = this.y - other.y;
        return new Vector2D(newX, newY);
    }
    */

    public Vector2D plus(Vector2D other) {
        double newX = this.x + other.x;
        double newY = this.y + other.y;
        return new Vector2D(newX, newY);
    }

    public Vector2D multiplyByScalar(double scalar) {
        double newX = this.x * scalar;
        double newY = this.y * scalar;
        return new Vector2D(newX, newY);
    }

    public Vector2D rotateCC(double angle) {
        double newX = Math.cos(angle) * this.x - Math.sin(angle) * this.y;
        double newY = Math.sin(angle) * this.x + Math.cos(angle) * this.y;
        return new Vector2D(newX, newY);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

}
/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D other = (Vector2D) o;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }*/
