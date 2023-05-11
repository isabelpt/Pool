import java.awt.*;
import java.util.ArrayList;

public class Table {
    public final static int height = 500;
    public final static int width = 800;
    public final static int playHeight = 500;
    public final static int playWidth = 800;
    public static final Double friction = 0.9;
    public static final Color[] ballColors = {Color.red, Color.orange, Color.yellow, Color.green,
            Color.cyan};
    private ArrayList<Ball> balls;
    private Ball b;
    private Pocket[] pockets;
    private Pocket pocket;
    private Image img;
    private PoolGame game;

    public Table(Ball b, PoolGame game) {
        this.b = b;
        int x = -10;
        int y = 29 - 10;
        pockets = new Pocket[6];
        for (int i = 0; i < 5; i += 2) {
            pockets[i] = new Pocket(x, y, this);
            pockets[i + 1] = new Pocket(x, 500 - 30, this);
            x += playWidth / 2 - 10;
        }
    }

    public void checkWallCollision() {
        b.bounceWall();
    }

    public void checkPockets() {
        for (Pocket p: pockets) {
            p.inPocket(b);
        }
    }

    // From: https://www.w3schools.blog/java-every-second
    public void switchPocketColors() {
        // Get random pocket
        for (Pocket p : pockets) {
            p.setC(p.defaultColor);
        }
        int index = (int) (Math.random() * pockets.length);
        pockets[index].setC(b.getColor());
    }


    public void draw(Graphics g, PoolView window) {
        g.setColor(new Color(50, 168, 82));
        g.fillRect(0, 0, width, height);
        for(Pocket p: pockets) {
            p.draw(g);
        }
        g.setColor(Color.yellow);
    }
}
