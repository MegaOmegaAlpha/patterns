package lab3.templateMethod.figures;

import sl.shapes.StarPolygon;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MovingStar extends AbstractFigure {

    private StarPolygon starPolygon;
    private int figureSpeed;
    private int screenWidth;
    private int screenHeight;
    private int xSpeed;
    private int ySpeed;
    private int size;
    private int calculatedX;
    private int calculatedY;

    public MovingStar(int x, int y, int size, int screenWidth, int screenHeight, int figureSpeed) {
        starPolygon = new StarPolygon(x - 40, y - 40, size, size / 2, 5);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.figureSpeed = figureSpeed;
        this.xSpeed = this.figureSpeed;
        this.ySpeed = this.figureSpeed;
        this.size = size;
    }

    @Override
    protected void calculateX() {
        Rectangle2D polygonBounds = starPolygon.getBounds2D();
        int currentX = (int) polygonBounds.getCenterX();
        currentX += xSpeed;
        if (currentX < size) {
            currentX = size;
            xSpeed = figureSpeed / 2;
        } else if (currentX > screenWidth - size) {
            currentX = screenWidth - size;
            xSpeed = -figureSpeed * 2;
        }
        this.calculatedX = currentX;
    }

    @Override
    protected void calculateY() {
        Rectangle2D polygonBounds = starPolygon.getBounds();
        int currentY = (int) polygonBounds.getCenterY();
        currentY += ySpeed;
        if (currentY < size) {
            currentY = size;
            ySpeed = figureSpeed;
        } else if (currentY > screenHeight - size) {
            currentY = screenHeight - size;
            ySpeed = -figureSpeed;
        }
        this.calculatedY = currentY;
        createNewStar();
    }

    private void createNewStar() {
        starPolygon = new StarPolygon(calculatedX, calculatedY, size, size / 2, 5);
    }

    @Override
    public Rectangle getBounds() {
        return starPolygon.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        return starPolygon.getBounds2D();
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
        return starPolygon.getPathIterator(affineTransform);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform affineTransform, double v) {
        return starPolygon.getPathIterator(affineTransform, v);
    }
}
