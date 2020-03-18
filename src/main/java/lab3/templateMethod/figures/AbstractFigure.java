package lab3.templateMethod.figures;

import java.awt.*;
import java.awt.geom.RectangularShape;

public abstract class AbstractFigure extends RectangularShape implements Shape {

    public void calculate() {
        calculateX();
        calculateY();
    }

    protected abstract void calculateX();
    protected abstract void calculateY();

}
