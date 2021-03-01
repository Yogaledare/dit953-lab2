package Model;

public interface IRamp extends IMovable{

    public void lower(double amount);

    public void raise(double amount);

    boolean isFullyRaised();

}
