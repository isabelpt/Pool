import javax.swing.*;
import java.awt.*;

public class Cue {
    private int x, y;
    private Ball whiteBall;
    private Double angle;
    private Image img;
    boolean launching;
    private boolean isVisible;
    private int distBall;

    public Cue(Ball b) {
        this.x = b.getStartX() + 24 + 10; // 24: diameter, 5 radius of outer circle
        this.y = b.getStartY() + 12 - 2;
        distBall = x - b.getX();
        launching = false;
        isVisible = true;
        angle = Math.toRadians(180);
        whiteBall = b;
        this.img = new ImageIcon("resources/cue.png").getImage();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public int distBall() {
        // get center of the ball
        double bx = whiteBall.getX() + whiteBall.getRadius();
        double by = whiteBall.getY() + whiteBall.getRadius();
        // get distance from center
        distBall = (int) Math.sqrt(Math.pow(x - bx, 2) + Math.pow(y - by, 2));
        return distBall;
    }

    public void resetPosition() {
        x = whiteBall.getX() + 24 + 10;
        y = whiteBall.getY() + 12 - 2;
    }

    public void draw(Graphics g, PoolView window) {
        if (whiteBall.getDx() == 0 && whiteBall.getDy() == 0) {
            g.setColor(Color.BLACK);
            Graphics2D g2d = (Graphics2D) g;

            Rectangle shape1 = new Rectangle(x, y, 300, 5);
            Rectangle shape2 = new Rectangle(x - 1010, y, 950, 2);
            g2d.rotate(angle, whiteBall.getX() + 12, whiteBall.getY() + 12);
            g2d.fill(shape1);
            g2d.draw(shape1);
            g2d.setColor(Color.white);
            g2d.fill(shape2);
            g2d.draw(shape2);
        } else {
            resetPosition();
        }

    }

}
