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
        table = new Table();
        this.b = new Ball(300, 200 + table.getHeight() / 2 - 12, 12, 2, 2, 7);
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
        cue.setY(b.getStartY() + 12);
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
        double Xd = mouseX - b.getX();
        double Yd = mouseY - b.getY();
        double radAngle = Math.atan(Yd/Xd);
        if (mouseX < b.getX()) {
            radAngle = radAngle + Math.toRadians(180);
        }
        cue.setAngle(radAngle);
        repaint();
    }
}
