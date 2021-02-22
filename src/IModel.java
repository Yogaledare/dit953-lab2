public interface IModel {
    void startEngine(Car car);
    void stopEngine(Car car);
    void gas(Car car);
    void brake(Car car);
    void raise(Car car);
    void lower(Car car);
    void setTurboOn(Car car);
    void setTurboOff(Car car);
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);

}
