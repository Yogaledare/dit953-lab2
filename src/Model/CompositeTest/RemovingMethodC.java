package Model.CompositeTest;


import Model.ITransportable;

import java.util.Deque;

@FunctionalInterface
public interface RemovingMethodC {
    public <T extends ITransportable> T apply(Deque<T> deque);
}

