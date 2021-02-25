package Model;

import View.ILoggable;

import java.util.List;

public interface LoggerObserver {
    void actOnPublish(List<? extends ILoggable> loggable);
}
