import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PoolView extends JFrame implements MouseListener, MouseMotionListener {
    private PoolGame game;
    private Ball b;
    private Table table;
    private Cue cue;
    public PoolView() {
        this.b = new Ball(600, 400, 12, 2, 2, 7);
        table = new Table();
        cue = new Cue(b);
    }

    public void startView() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 800);
        table.draw(g, this);
        b.draw(g);
        cue.draw(g, this);
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
//        b.setX(e.getX());
//        b.setY(e.getY());
        if (b.getX() - cue.getX() < 500) {
            cue.setX(cue.getX() + 2);
        }

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int newX = Math.abs(mouseX - b.getX()) + 5;
        int newY = Math.abs(mouseY - b.getY()) + 5;
        cue.setX(newX);
        cue.setY(newY);

        repaint();
    }
}
