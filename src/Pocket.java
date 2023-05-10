import java.awt.*;

public class Pocket {
    public final static int radius = 20;
    private int x, y;
    private Table table;
    public Pocket(int x, int y, Table table) {
        this.x = x;
        this.y = y;
        this.table = table;
    }

    public void inPocket(Ball b) {
        // Get center of the ball
        int bx = b.getX() + b.getRadius();
        int by = b.getY() + b.getRadius();

        // Get center of pocket
        int px = x + radius;
        int py = y + radius;

        // get distance
        int dist = (int) Math.hypot(bx - px, by - py);
        if (dist < radius) {
            b.setInPocket(true);
            if (b.equals(table.getB())) {
                b.reset();
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(60, 122, 77));
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}
