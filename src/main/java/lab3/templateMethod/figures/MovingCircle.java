package lab3.templateMethod.figures;

import java.awt.*;
import java.awt.geom.*;

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
    public Rectangle getBounds() {
        return null;
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
    public boolean contains(Point2D point2D) {
        return false;
    }

    @Override
    public boolean intersects(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D rectangle2D) {
        return false;
    }

    @Override
    public boolean contains(double v, double v1, double v2, double v3) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D rectangle2D) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return ellipse2D.getPathIterator(affineTransform);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return ellipse2D.getPathIterator(affineTransform, v);
    }
}
