/*
 * Created by JFormDesigner on Mon Mar 09 22:36:41 GMT+04:00 2020
 */

package lab3.observer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Vladimir
 */
public class Face extends JFrame {
    public Face() {
        initComponents();
        setContentPane(new FaceHolder(getWidth(), getHeight()));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vladimir

        //======== this ========
        Container contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 629, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 496, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vladimir
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

class FaceHolder extends JPanel {

    private boolean isNoseNormal;
    private boolean isLeftEyeClosed;
    private boolean isRightEyeClosed;
    private boolean isSmileOff;

    private Ellipse2D face;
    private Ellipse2D leftEye;
    private Ellipse2D rightEye;
    private Polygon nose;
    private Arc2D smile;

    public FaceHolder(int weight, int height) {
        this.face = new Circle(100, 40, 430);
        this.leftEye = new Circle(170, 140, 80);
        this.rightEye = new Circle(370, 140, 80);
        this.nose = new Triangle(275, 350, 310, 200, 345, 350);
        smile = new Arc2D.Double();
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (nose.contains(mouseEvent.getX(), mouseEvent.getY())) {
                    isNoseNormal = !isNoseNormal;
                } else if (leftEye.contains(mouseEvent.getX(), mouseEvent.getY())) {
                    isLeftEyeClosed = !isLeftEyeClosed;
                } else if (rightEye.contains(mouseEvent.getX(), mouseEvent.getY())) {
                    isRightEyeClosed = !isRightEyeClosed;
                } else if (smile.contains(mouseEvent.getX(), mouseEvent.getY())) {
                    isSmileOff = !isSmileOff;
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(Color.YELLOW);
        graphics2D.fill(face);

        graphics2D.setColor(Color.BLACK);

        if (isLeftEyeClosed) {
            graphics2D.draw(leftEye);
        } else {
            graphics2D.fill(leftEye);
        }
        if (isRightEyeClosed) {
            graphics2D.draw(rightEye);
        } else {
            graphics2D.fill(rightEye);
        }
        if (!isSmileOff) {
            smile.setArc(250, 380, 120, 10, 180, 180, Arc2D.OPEN);
        } else {
            smile.setArc(250, 380, 120, 50, 180, 180, Arc2D.OPEN);
        }
        graphics2D.draw(smile);

        if (!isNoseNormal) {
            graphics2D.setColor(Color.BLUE);
        } else {
            graphics2D.setColor(Color.PINK);
        }
        graphics2D.fill(nose);

    }

}

class Circle extends Ellipse2D {

    private double x;
    private double y;
    private double height;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.height = radius;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setFrame(double v, double v1, double v2, double v3) {
        this.x = v;
        this.y = v1;
        this.height = v3;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}

class Triangle extends Polygon {

    public Triangle(int ax, int ay, int bx, int by, int cx, int cy) {
        super(new int[] {ax, bx, cx}, new int[] {ay, by, cy}, 3);
    }

}

