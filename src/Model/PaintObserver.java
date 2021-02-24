package Model;

import View.IPaintable;

import java.util.List;

public interface PaintObserver {
    void actOnPublish(List<? extends IPaintable> paintables);
}
