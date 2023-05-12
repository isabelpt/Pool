import java.awt.*;

/**
 * Table class, contains pockets
 * Tracks pocket, ball interactions
 */
public class Table {
    // Instance Variables
    public final static int height = 500;
    public final static int width = 800;
    public static final Color[] ballColors = {Color.red, Color.orange, Color.yellow, Color.green,
            Color.cyan};
    private Ball b;
    private Pocket[] pockets;

    /**
     * Constructor
     * @param b ball
     * @param game backend
     */
    public Table(Ball b, PoolGame game) {
        this.b = b;
        int x = -10; // -10 shift to show only half of ball
        int y = 29 - 10; // -10 shift for half radius and 29 shift for top bar

        // Create 6 pockets
        pockets = new Pocket[6];
        for (int i = 0; i < 5; i += 2) {
            pockets[i] = new Pocket(x, y, this);
            pockets[i + 1] = new Pocket(x, game.WINDOW_HEIGHT - 30, this);
            x += game.WINDOW_WIDTH / 2 - 10;
        }
    }

    /**
     * Get ball
     * @return
     */
    public Ball getB() {
        return b;
    }

    /**
     * Check each pocket if ball is inside
     */
    public void checkPockets() {
        for (Pocket p: pockets) {
            p.inPocket();
        }
    }

    /**
     * Switch pocket with color
     * Reset every pocket and choose new pocket to have color
     */
    public void switchPocket() {
        // Reset all pockets
        for (Pocket p : pockets) {
            p.resetC();
        }

        // Choose pocket to have color
        int index = (int) (Math.random() * pockets.length);
        pockets[index].setC(b.getColor());
    }

    /**
     * Draw table (background and pockets)
     * @param g
     * @param window
     */
    public void draw(Graphics g, PoolView window) {
        g.setColor(new Color(50, 168, 82));
        g.fillRect(0, 0, width, height);
        for(Pocket p: pockets) {
            p.draw(g);
        }
    }
}
