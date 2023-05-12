import java.awt.*;

/**
 * Ball class
 * Move and draw ball
 * @author isabelprado
 * @version 5/12/23
 */
public class Ball {
    // Instance variables
    private int x, y;
    private int startX, startY;
    private int radius;
    private int dx, dy;
    private Color color;
    private final static double friction = 0.95;
    private boolean inPocket;
    private PoolGame game;
    private int round;

    /**
     * Constructor
     * @param startX initial x-value
     * @param startY initial y-value
     * @param radius set radius
     * @param game backend
     */
    public Ball(int startX, int startY, int radius, PoolGame game) {
        this.startX = startX;
        this.startY = startY;
        x = startX;
        y = startY;
        this.radius = radius;
        this.dx = 0;
        this.dy = 0;
        round = 0;
        this.color = game.getTable().ballColors[round];
        round++;
        this.game = game;
        inPocket = false;
    }

    /**
     * Getter and setter methods
     * @return
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getRadius() {
        return radius;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Color getColor() {
        return color;
    }

    public void setInPocket(boolean inPocket) {
        this.inPocket = inPocket;
    }

    /**
     * Move ball (change x and y)
     * Update dx and dy based on coefficient of friction
     */
    public void move() {
        x += dx;
        y += dy;
        dx = (int) (dx * friction);
        dy = (int) (dy * friction);
    }

    /**
     * If the ball is in contact with the wall,
     * bounce of by flipping dx or dy
     */
    public void bounceWall() {
        if ((x <= 0 && dx < 0) || (x >= game.WINDOW_WIDTH - radius * 2 && dx > 0)) {
            dx = -dx;
        }
        if ((y <= 50 && dy < 0) || (y >= game.WINDOW_HEIGHT - radius * 2 && dy > 0)) {
            dy = -dy;
        }
    }

    /**
     * Reset to initial starting position
     */
    public void reset() {
        x = startX;
        y = startY;
        dx = 0;
        dy = 0;
        game.getCue().resetPosition();
        inPocket = false;
    }

    /**
     * Keep track of round and rotate through colors
     */
    public void changeColor() {
        if (round == 5) {
            game.end();
            return;
        }
        color = game.getTable().ballColors[round];
        round++;
    }

    /**
     * Draw ball as long as it is not in the pocket
     * @param g
     */
    public void draw(Graphics g) {
        if(!inPocket) {
            g.setColor(color);
            g.fillOval(x, y, 2 * radius, 2 * radius);
        }
    }
}
