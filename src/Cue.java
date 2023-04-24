import java.awt.*;

public class Cue {
    private int x, y;
    private int startX, startY;
    private int dx, dy;
    private int width, height;
    private Ball whiteBall;
    private Double angle;
    private Image img;

    public Cue(int startX, int startY, int width, int height, Ball whiteBall, Double angle, Image img) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.whiteBall = whiteBall;
        this.angle = angle;
        this.img = img;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getWhiteBall() {
        return whiteBall;
    }

    public void setWhiteBall(Ball whiteBall) {
        this.whiteBall = whiteBall;
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

    public void rotate(Double nAngle) {

    }

    public void drag() {

    }

    public void drawTrajectory(Ball b) {

    }
}
