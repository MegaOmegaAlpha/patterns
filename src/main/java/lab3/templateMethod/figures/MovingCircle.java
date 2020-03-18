package lab3.templateMethod.figures;

import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

public class MovingCircle extends AbstractFigure {

    private Ellipse2D ellipse2D;
    private int figureSpeed;
    private int screenWidth;
    private int screenHeight;
    private int xSpeed;
    private int ySpeed;

    public MovingCircle(int x, int y, int size, int screenWidth, int screenHeight, int figureSpeed) {
        ellipse2D = new Ellipse2D.Double(x, y, size, size);
        this.figureSpeed = figureSpeed;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.xSpeed = figureSpeed;
        this.ySpeed = figureSpeed;
    }

    @Override
    protected void calculateX() {
        ellipse2D.setFrame(ellipse2D.getX() + xSpeed, ellipse2D.getY(), ellipse2D.getWidth(), ellipse2D.getHeight());
        if (ellipse2D.getX() < 0) {
            ellipse2D.setFrame(0, ellipse2D.getY(), ellipse2D.getWidth(), ellipse2D.getHeight());
            xSpeed = figureSpeed;
        } else if (ellipse2D.getX() > screenWidth - 40) {
            ellipse2D.setFrame(screenWidth - 40, ellipse2D.getY(), ellipse2D.getWidth(), ellipse2D.getHeight());;
            xSpeed = -figureSpeed;
        }
    }

    @Override
    protected void calculateY() {
        ellipse2D.setFrame(ellipse2D.getX(), ellipse2D.getY() + ySpeed, ellipse2D.getWidth(), ellipse2D.getHeight());
        if (ellipse2D.getY() < 0) {
            ellipse2D.setFrame(ellipse2D.getX(), 0, ellipse2D.getWidth(), ellipse2D.getHeight());
            ySpeed = figureSpeed;
        } else if (ellipse2D.getY() > screenHeight - 40) {
            ellipse2D.setFrame(ellipse2D.getX(), screenHeight - 40, ellipse2D.getWidth(), ellipse2D.getHeight());
            ySpeed = -figureSpeed;
        }
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double v, double v1, double v2, double v3) {
        ellipse2D.setFrame(v, v1, v2, v3);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return ellipse2D.getBounds2D();
    }

    @Override
    public boolean contains(double v, double v1) {
        return false;
    }

    @Override
    public boolean intersects(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean contains(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return ellipse2D.getPathIterator(affineTransform);
    }
}
