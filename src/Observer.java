import java.util.List;

public interface Observer {
    void actOnPublish(List<? extends IPaintable> observers);
}
