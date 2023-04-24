import java.awt.*;

public class Table {
    private int height, width;
    private Ball[] balls;
    private Image img;

    public Table(int height, int width, Ball[] balls, Image img) {
        this.height = height;
        this.width = width;
        this.balls = balls;
        this.img = img;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Ball[] getBalls() {
        return balls;
    }

    public void setBalls(Ball[] balls) {
        this.balls = balls;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void checkBallCollisions() {

    }

    public void checkWallCollisions() {

    }

    public void checkPockets() {

    }

    public void setTriangle() {

    }
}
