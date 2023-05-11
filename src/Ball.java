import java.awt.*;

public class Ball {
    private int x, y;
    private int startX, startY;
    private int radius;
    private int dx, dy;
    private Color color;
    private final static double friction = 0.95;
    private boolean inPocket;
    private PoolGame game;
    private int round;

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

    public void move() {
        x += dx;
        y += dy;
        dx = (int) (dx * friction);
        dy = (int) (dy * friction);
    }

    public void move(double velocity, double angle) {
        dx = (int) (velocity * Math.cos(angle)) * -1;
        dy = (int) (velocity * Math.sin(angle)) * -1;
        x += (int) (dx * friction + 0.5);
        y += (int) (dy * friction + 0.5);
        System.out.println("X: " + dx * friction);
        System.out.println("Y: " + dy * friction);
    }

    public void bounceWall() {
        if ((x <= 0 && dx < 0) || (x >= game.WINDOW_WIDTH - radius * 2 && dx > 0)) {
            dx = -dx;
        }
        if ((y <= 50 && dy < 0) || (y >= game.WINDOW_HEIGHT - radius * 2 && dy > 0)) {
            dy = -dy;
        }
    }

    public void reset() {
        x = startX;
        y = startY;
        dx = 0;
        dy = 0;
        game.getCue().resetPosition();
        inPocket = false;
    }

    public void changeColor() {
        if(round == 5) {
            game.end();
            return;
        }
        color = game.getTable().ballColors[round];
        round++;
    }

    public void draw(Graphics g) {
        if(!inPocket) {
            g.setColor(color);
            g.fillOval(x, y, 2 * radius, 2 * radius);
        }
    }
}
