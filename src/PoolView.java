import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PoolView extends JFrame implements MouseListener, MouseMotionListener {
    private PoolGame game;
    private Ball b;
    private Table table;
    public PoolView() {
        this.b = new Ball(100, 100, 12, 2, 2, 7);
        table = new Table();
    }

    public void startView() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 800);
        table.draw(g, this);
        b.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        b.setX(e.getX());
        b.setY(e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
