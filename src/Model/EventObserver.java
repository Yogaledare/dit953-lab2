package Model;

import View.ILoggable;
import View.IPaintable;

import java.util.List;

public interface EventObserver <T> {
    void actOnPublish(List<? extends T> loggable);
}
