package lab3.templateMethod.figures;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MovingCube extends AbstractFigure {

    private int screenWidth;
    private int screenHeight;
    private int figureSpeed;
    private int xSpeed;
    private int ySpeed;
    private Rectangle rectangle;

    public MovingCube(int x, int y, int side, int screenWidth, int screenHeight, int figureSpeed) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.figureSpeed = figureSpeed;
        this.xSpeed = figureSpeed;
        this.ySpeed = figureSpeed;

        rectangle = new Rectangle(x, y, side, side);
    }

    @Override
    protected void calculateX() {
        rectangle.x += xSpeed;
        if (rectangle.x < 0) {
            rectangle.x = 0;
            xSpeed = figureSpeed;
        } else if (rectangle.x > screenWidth - 40) {
            rectangle.x = screenWidth - 40;
            xSpeed = -figureSpeed;
        }
    }

    @Override
    protected void calculateY() {
        rectangle.y += ySpeed;
        if (rectangle.y < 0) {
            rectangle.y = 0;
            ySpeed = figureSpeed;
        } else if (rectangle.y > screenHeight - 40) {
            rectangle.y = screenHeight - 40;
            ySpeed = -figureSpeed;
        }
    }

    @Override
    public Rectangle getBounds() {
        return rectangle;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return new Rectangle2D.Double(rectangle.x, rectangle.y, rectangle.height, rectangle.width);
    }

    @Override
    public boolean contains(double v, double v1) {
        return false;
    }

    @Override
    public double getX() {
        return rectangle.x;
    }

    @Override
    public double getY() {
        return rectangle.y;
    }

    @Override
    public double getWidth() {
        return rectangle.width;
    }

    @Override
    public double getHeight() {
        return rectangle.height;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double v, double v1, double v2, double v3) {

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
        return rectangle.getPathIterator(affineTransform);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return rectangle.getPathIterator(affineTransform, v);
    }
}
