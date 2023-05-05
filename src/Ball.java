import java.awt.*;

public class Ball {
    private int x, y;
    private int startX, startY;
    private int radius;
    private int dx, dy;
    private Color color;
    private boolean isTouchingBall;
    private boolean isTouchingWall;
    private boolean inPocket;
    private boolean onBoard;
    private Player owner;
    private Double angle;
    private Image img;

    public Ball(int startX, int startY, int radius, Color color) {
        this.startX = startX;
        this.startY = startY;
        x = startX;
        y = startY;
        this.radius = radius;
        this.dx = 0;
        this.dy = 0;
        this.color = color;
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

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
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
    }

    public void move(double velocity, double angle) {

    }

    public void bounceWall() {

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
