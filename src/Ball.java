import java.awt.*;

public class Ball {
    private int x, y;
    private int startX, startY;
    private int radius;
    private int dx, dy;
    private Color color;
    private final static double friction = 0.95;
    private boolean isTouchingBall;
    private boolean isTouchingWall;
    private boolean inPocket;
    private boolean onBoard;
    private Double angle;
    private Image img;
    private PoolGame game;

    public Ball(int startX, int startY, int radius, Color color, PoolGame game) {
        this.startX = startX;
        this.startY = startY;
        x = startX;
        y = startY;
        this.radius = radius;
        this.dx = 0;
        this.dy = 0;
        this.color = color;
        this.game = game;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
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


    public boolean isTouchingBall() {
        return isTouchingBall;
    }

    public void setTouchingBall(boolean touchingBall) {
        isTouchingBall = touchingBall;
    }

    public boolean isTouchingWall() {
        return isTouchingWall;
    }

    public void setTouchingWall(boolean touchingWall) {
        isTouchingWall = touchingWall;
    }

    public boolean isInPocket() {
        return inPocket;
    }

    public void setInPocket(boolean inPocket) {
        this.inPocket = inPocket;
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
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
//        while (dx > 0 || dy > 0) {
//            x += dx;
//            y += dx;
//            dx = (int) (dx * friction);
//            dy = (int) (dx * friction);
//        }
        x += (int) (dx * friction);
        y += (int) (dy * friction);
        System.out.println("X: " + dx * friction);
        System.out.println("Y: " + dy * friction);
    }

    public void bounceWall() {
//        if ((x <= 0 && dx < 0) || (x >= tankWidth - tank.getFishImages()[0].getHeight(tank) && dx > 0)) {
//            dx = -dx;
//        }
//        // Image does not take up all 120 px vertically, so have to subtract 90 instead
//        if ((y <= 0 && dy < 0) || (y >= tankHeight - (90) && dy > 0)) {
//            dy = -dy;
//        }
        if ((x <= 0 && dx < 0) || (x >= game.WINDOW_WIDTH - radius * 2 && dx > 0)) {
            dx = -dx;
        }
        if ((y <= 50 && dy < 0) || (y >= game.WINDOW_HEIGHT - radius * 2 && dy > 0)) {
            dy = -dy;
        }
    }

    public void bounceBall(Ball other) {

    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2 * radius, 2 * radius);
//        g.setColor(Color.red);
//        g.drawOval(x - 10, y - 10, 2* radius + 20, 2*radius + 20);
    }
}
