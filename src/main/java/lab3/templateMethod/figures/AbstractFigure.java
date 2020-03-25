package lab3.templateMethod.figures;

import java.awt.*;

public abstract class AbstractFigure implements Shape {

    public void move() {
        calculateX();
        calculateY();
    }

    protected abstract void calculateX();
    protected abstract void calculateY();

}
