package Model;

public class CarFactory {
    public static IVehicle createVolvo240(Vector2D position){
        return new Volvo240(position);
    }

    public static ITurboVehicle createSaab95(Vector2D position){
        return new Saab95(position);
    }

    public static IRampVehicle createScania(Vector2D position){
        return new Scania(position);
    }
}
