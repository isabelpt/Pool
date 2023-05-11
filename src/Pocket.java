import java.awt.*;

public class Pocket {
    public final static int radius = 20;
    private int x, y;
    private Table table;
    private Color c;
    public static final Color defaultColor = new Color(60, 122, 77);
    public Pocket(int x, int y, Table table) {
        this.x = x;
        this.y = y;
        this.table = table;
        c = defaultColor;
    }

    public void setC(Color c) {
        this.c = c;
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
        if (dist < radius + 5) {
            b.setInPocket(true);
            b.reset();
            if (b.getColor().equals(c)) {
                b.changeColor();
            }
            c = defaultColor;

        }

    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}
