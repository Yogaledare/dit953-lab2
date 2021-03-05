package DecoratorTest;

import Model.Vector2D;

public abstract class BaseFancyCar {
    protected ICar parent;
    BaseFancyCar(ICar parent){
        this.parent = parent;
    }

    public boolean isEngineOn() {
        return parent.isEngineOn();
    }

    public boolean isMoving() {
        return parent.isMoving();
    }

    public Vector2D getPosition() {
        return parent.getPosition();
    }

    public Vector2D getDirection() {
        return parent.getDirection();
    }

    public String getModelName() {
        return parent.getModelName();
    }

    public double getCurrentSpeed() {
        return parent.getCurrentSpeed();
    }
}
