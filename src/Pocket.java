import java.awt.*;

/**
 * Pocket class
 */
public class Pocket {
    // Instance variables
    private final static int radius = 20;
    private int x, y;
    private Table table;
    private Color c;
    private static final Color defaultColor = new Color(60, 122, 77);

    /**
     * Constructor
     * @param x
     * @param y
     * @param table
     */
    public Pocket(int x, int y, Table table) {
        this.x = x;
        this.y = y;
        this.table = table;
        c = defaultColor;
    }

    /**
     * Set color
     * @param c
     */
    public void setC(Color c) {
        this.c = c;
    }

    /**
     * Reset color to default
     */
    public void resetC() {
        c = defaultColor;
    }

    /**
     * Check if ball is in the pocket
     * If it is, reset the ball and change colors
     */
    public void inPocket() {
        Ball b = table.getB();
        // Get center of the ball
        int bx = b.getX() + b.getRadius();
        int by = b.getY() + b.getRadius();

        // Get center of pocket
        int px = x + radius;
        int py = y + radius;

        // Get distance
        int dist = (int) Math.hypot(bx - px, by - py);

        // If ball in pocket, reset the ball
        if (dist < radius + 5) {
            b.setInPocket(true);
            b.reset();
            // If colors match, change ball color
            if (b.getColor().equals(c)) {
                b.changeColor();
            }
            c = defaultColor;

        }

    }

    /**
     * Draw pocket as circle with x, y, and radius
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}
