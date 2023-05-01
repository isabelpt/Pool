import java.awt.*;

public class Pocket {
    public final static int radius = 20;
    private int x, y;
    public Pocket(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(60, 122, 77));
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}
