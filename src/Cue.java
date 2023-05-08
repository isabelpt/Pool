import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Cue {
    private int x, y;
    private int startX, startY;
    private int dx, dy;
    private int width, height;
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
//        this.width = width;
//        this.height = height;
     //   this.angle = angle;
        launching = false;
        isVisible = true;
        angle = Math.toRadians(180);
        whiteBall = b;
        this.img = new ImageIcon("resources/cue.png").getImage();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isLaunching() {
        return launching;
    }

    public void setLaunching(boolean launching) {
        this.launching = launching;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
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

    public double getVelocity() {
        return distBall;
    }

    public boolean checkCollision() {
//        // get center of the ball
//        double bx = whiteBall.getX() + whiteBall.getRadius();
//        double by = whiteBall.getY() + whiteBall.getRadius();
//        // get distance from center
//        int dist = (int) Math.sqrt(Math.pow(x - bx, 2) + Math.pow(y - by, 2));
        distBall = distBall();
        System.out.println(distBall);
        if (distBall <= 12) {

            return true;
        }
        return false;
    }

    public void resetPosition() {
        x = whiteBall.getX() + 24 + 10;
        y = whiteBall.getY() + 12 - 2;
    }
    public void drawTrajectory(Ball b) {

    }

    public void draw(Graphics g, PoolView window) {
        if (whiteBall.getDx() == 0 && whiteBall.getDy() == 0) {
            //resetPosition();
            g.setColor(Color.BLACK);
            //g.fillRect(whiteBall.getX() - x - 5, whiteBall.getY() + whiteBall.getRadius() - 5, 400, 5);
            //g.drawImage(img, whiteBall.getX() - x, whiteBall.getY() - whiteBall.getRadius() / 2, 400, 50, window);
            Graphics2D g2d = (Graphics2D) g;
            //AffineTransform tx = new AffineTransform();
            //tx.rotate(0.5);

            Rectangle shape = new Rectangle(x, y, 300, 5);
            g2d.rotate(angle, whiteBall.getX() + 12, whiteBall.getY() + 12); // Rotate around the center of the ball
            g2d.fill(shape);
            g2d.draw(shape);
            //g2d.drawImage(img, x, y, 200, 50, window);
        } else {
            resetPosition();
        }

    }

}
