import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PoolView extends JFrame implements MouseListener, MouseMotionListener {
    private PoolGame game;
    private Ball b;
    private Table table;
    private Cue cue;
    public PoolView() {
        this.b = new Ball(200, 500 / 2 + 12, 12, Color.white);
        table = new Table(b);
        cue = new Cue(b);
        infoBox("Welcome to pool! To play, rotate the cue and pull back to release it. The game ends when you pocket the 8-ball. Good luck!", "PoolGame");
    }

    public void startView() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, game.WINDOW_WIDTH, game.WINDOW_HEIGHT);
        table.draw(g, this);
        ArrayList<Ball> balls = table.getBalls();
        for (Ball ball: balls) {
            ball.draw(g);
        }
        b.draw(g);
        cue.draw(g, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cue.setX(b.getStartX() + 24 + 10);
        cue.setY(b.getStartY() + 12 - 2);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        b.setX(e.getX());
//        b.setY(e.getY());
        // need to make sure that the cursor is moving away from the ball
        if (cue.getX() - b.getX() < 75) {
            cue.setX(cue.getX() + 1);
        }

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        /**
         * https://www.instructables.com/Using-Java-to-Rotate-an-Object-to-Face-the-Mouse/
         * http://www.java2s.com/example/java/2d-graphics/draw-a-rotated-rectangle.html
         * 
         */
        int mouseX = e.getX();
        int mouseY = e.getY();
        double Xd = mouseX - b.getX();
        double Yd = mouseY - b.getY();
        double radAngle = Math.atan(Yd/Xd);
        if (mouseX < b.getX()) {
            radAngle = radAngle + Math.toRadians(180);
        }
        cue.setAngle(radAngle);
        repaint();

    }

    //
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE);
    }
}
