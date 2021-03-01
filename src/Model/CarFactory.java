package Model;

public class CarFactory {
    public static IMovable createVolvo240(Vector2D position){
        return new Volvo240(position);
    }

    public static ITurbo createSaab95(Vector2D position){
        return new Saab95(position);
    }

    public static IRamp createScania(Vector2D position){
        return new Scania(position);
    }
}
