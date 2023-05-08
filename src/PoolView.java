import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.image.BufferStrategy;

public class PoolView extends JFrame implements MouseListener, MouseMotionListener {
    private PoolGame game;
    private Ball b;
    private Table table;
    private Cue cue;
    private int tempdX, tempdY;
    private double tempAngle;
    public PoolView(PoolGame game) {
        this.game = game;
        this.b = game.getB();
        this.table = game.getTable();
        this.cue = game.getCue();
        tempAngle = 0;
        tempdX = 0;
        tempdY = 0;

        infoBox("Welcome to pool! To play, rotate the cue and pull back to release it. The game ends when you pocket the 8-ball. Good luck!", "PoolGame");

        this.setSize(game.WINDOW_WIDTH, game.WINDOW_HEIGHT);
        this.setVisible(true);
        this.createBufferStrategy(2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.repaint();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

//        this.repaint();
    }

    public void startView() {

    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g) {
//        cue.resetPosition();
        g.setColor(Color.black);
        g.fillRect(0, 0, game.WINDOW_WIDTH, game.WINDOW_HEIGHT);
        table.draw(g, this);
        ArrayList<Ball> balls = table.getBalls();
        for (Ball ball: balls) {
            ball.draw(g);
        }
        b.draw(g);
        if(cue.isVisible()) {
            cue.draw(g, this);
        }
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
        cue.resetPosition();
//        if(cue.checkCollision()) {
//            // set ball velocity and angle
//            // b.move()
//        }
        //cue.setVisible(false);
        b.setDx(tempdX);
        b.setDy(tempdY);
        b.setAngle(tempAngle);
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
        // adjust speed based on how far back the cue goes
        tempAngle = cue.getAngle();
        tempdX = (int) (Math.min(cue.distBall(), 63) * Math.cos(cue.getAngle()) * -1);
        tempdY = (int) (Math.min(cue.distBall(), 63) * Math.sin(cue.getAngle()) * -1);
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
