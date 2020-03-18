package lab3.templateMethod;

import lab3.templateMethod.figures.AbstractFigure;
import lab3.templateMethod.figures.MovingCircle;
import lab3.templateMethod.figures.MovingCube;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AnimatedLayer extends JPanel {

    private static final int SQUARE_SIZE = 40;
    private static final int SPEED_OF_SQUARE = 6;

    private Map<Thread, AbstractFigure> rectangles = new HashMap<>();

    public AnimatedLayer() {

    }

    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (AbstractFigure cube : rectangles.values()) {
            graphics2D.fill(cube);
            //g.fillRect((int) cube.getX(), (int) cube.getY(), SQUARE_SIZE, SQUARE_SIZE);
        }
        //g.fillRect(xPosit, yPosit, SQUARE_SIZE, SQUARE_SIZE);
    }

    public void run(String figureName) {
        AbstractFigure movingFigure = createFigureByName(figureName);
        new Thread(() -> {
            rectangles.put(Thread.currentThread(), movingFigure);
            while (true) {
                redraw(Thread.currentThread());
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
    }

    private AbstractFigure createFigureByName(String name) {
        switch (name) {
            case "RECTANGLE":
                return new MovingCube(getWidth(), getHeight(), SQUARE_SIZE, getWidth(), getHeight(), SPEED_OF_SQUARE);
            case "CIRCLE":
                return new MovingCircle(getWidth(), getHeight(), SQUARE_SIZE, getWidth(), getHeight(), SPEED_OF_SQUARE);
            default:
                return new MovingCube(getWidth(), getHeight(), SQUARE_SIZE, getWidth(), getHeight(), SPEED_OF_SQUARE);
        }
    }

    private void redraw(Thread thread) {
        rectangles.get(thread).calculate();
    }

}