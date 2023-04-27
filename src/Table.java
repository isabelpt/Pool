import javax.swing.*;
import java.awt.*;

public class Table {
    // private int height, width;
    public final static int height = 500;
    public final static int width = 800;
    public final static int playHeight = 400;
    public final static int playWidth = 700;
    private static final Double friction = 0.9;
    private Ball[] balls;
    private Ball b;
    private Image img;

    public Table() {
        //this.balls = balls;
        this.img = new ImageIcon("resources/table.png").getImage();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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

    public void draw(Graphics g, PoolView window) {

        g.drawImage(img, 100, 200, width, height, window);

        g.setColor(Color.yellow);
        //g.fillRect(200, 300, playWidth, playHeight);
    }
}
