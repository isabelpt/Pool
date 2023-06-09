import java.awt.*;

/**
 * Cue class
 * Control movement and draw
 * @author isabelprado
 * @version 5/12/23
 */
public class Cue {
    private int x, y;
    private Ball b;
    private Double angle;
    private boolean isVisible;
    private int distBall;
    private static final int cWidth = 300;
    private static final int cHeight = 5;
    private static final int tWidth = 950;
    private static final int tHeight = 2;
    private static final int pullBackDist = 75;


    public Cue(Ball b) {
        this.x = b.getStartX() + b.getRadius() * 2 + 10; // 5: radius of outer circle
        this.y = b.getStartY() + b.getRadius() - 2; // 2: height / 2
        distBall = x - b.getX(); // Store distance from ball
        isVisible = true;
        angle = Math.toRadians(180);
        this.b = b;
    }

    /**
     * Getter and setter methods
     * @return
     */
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
    public int getPullBackDist() {
        return pullBackDist;
    }

    /**
     * Calculate the distance from the ball with distance formula
     * @return distance
     */
    public int distBall() {
        // get center of the ball
        double bx = b.getX() + b.getRadius();
        double by = b.getY() + b.getRadius();
        // get distance from center
        distBall = (int) Math.sqrt(Math.pow(x - bx, 2) + Math.pow(y - by, 2));
        return distBall;
    }

    /**
     * Reset to default distance from ball
     */
    public void resetPosition() {
        x = b.getX() + b.getRadius() * 2 + 10;
        y = b.getY() + b.getRadius() - cHeight / 2;
    }

    /**
     * Draw cue and trajectory
     * @param g
     * @param window
     */
    public void draw(Graphics g, PoolView window) {
        // Only draw cue if the ball is not moving
        if (b.getDx() == 0 && b.getDy() == 0) {
            g.setColor(Color.BLACK);

            // Create 2D Graphics to perform rotation
            Graphics2D g2d = (Graphics2D) g;

            // Shapes to draw: cue and trajectory
            Rectangle shape1 = new Rectangle(x, y, cWidth, cHeight);
            Rectangle shape2 = new Rectangle(x - (tWidth + pullBackDist - b.getRadius()), y, tWidth, tHeight);

            // Rotate around center of the ball
            g2d.rotate(angle, b.getX() + b.getRadius(), b.getY() + b.getRadius());

            // Draw shapes
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
