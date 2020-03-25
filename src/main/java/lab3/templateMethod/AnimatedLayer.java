package lab3.templateMethod;

import lab3.templateMethod.figures.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AnimatedLayer extends JPanel {

    private static final int FIGURE_SIZE = 40;
    private static final int FIGURE_SPEED = 6;

    private Map<Thread, AbstractFigure> map = new HashMap<>();

    public AnimatedLayer() {

    }

    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        for (AbstractFigure figure : map.values()) {
            graphics2D.fill(figure);
        }
    }

    public void run(String figureName) {
        AbstractFigure movingFigure = createFigureByName(figureName);
        new Thread(() -> {
            map.put(Thread.currentThread(), movingFigure);
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
                return new MovingCube(getWidth(), getHeight(), FIGURE_SIZE, getWidth(), getHeight(), FIGURE_SPEED);
            case "CIRCLE":
                return new MovingCircle(getWidth(), getHeight(), FIGURE_SIZE, getWidth(), getHeight(), FIGURE_SPEED);
            case "STAR":
                return new MovingStar(getWidth(), getHeight(), FIGURE_SIZE, getWidth(), getHeight(), FIGURE_SPEED);
            default:
                return new MovingCube(getWidth(), getHeight(), FIGURE_SIZE, getWidth(), getHeight(), FIGURE_SPEED);
        }
    }

    private void redraw(Thread thread) {
        map.get(thread).move();
    }

}