import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import java.awt.image.BufferStrategy;

/**
 * PoolView (frontend)
 * Displays graphics and takes in mouse movement
 * @author isabelprado
 * @version 5/12/23
 */
public class PoolView extends JFrame implements MouseListener, MouseMotionListener {
    // Instance variables
    private PoolGame game;
    private Ball b;
    private Table table;
    private Cue cue;
    private int tempdX, tempdY;

    /**
     * Constructor
     * @param game backend
     */
    public PoolView(PoolGame game) {
        this.game = game;
        this.b = game.getB();
        this.table = game.getTable();
        this.cue = game.getCue();
        tempdX = 0;
        tempdY = 0;

        // Display instructions
        infoBox("Welcome to pool! Try to get the balls into the corresponding color pocket as quickly as possible. Good luck!", "PoolGame");

        // Window settings
        this.setSize(game.WINDOW_WIDTH, game.WINDOW_HEIGHT);
        this.setVisible(true);
        this.createBufferStrategy(2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.repaint();

        // Establish mouse controls
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /**
     * Double buffered paint method
     * Calls myPaint()
     * @param g the specified Graphics window
     */
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

    /**
     * Paints each game element: table, cue, and ball
     * @param g
     */
    public void myPaint(Graphics g) {
        table.draw(g, this);
        if(cue.isVisible()) {
            cue.draw(g, this);
        }
        b.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * When mouse is released, set ball's dx and dy to how far the cue was pulled back
     * Resets cue to reflect ball position
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        cue.resetPosition();
        b.setDx(tempdX);
        b.setDy(tempdY);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Move back cue while the mouse is dragged back
     * Keep track of how far the mouse is dragged with tempDx and tempDy
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        // Allow user to bull back the cue until at 75 (arbitrary distance)
        if (cue.getX() - b.getX() < cue.getPullBackDist()) {
            cue.setX(cue.getX() + 1);
        }

        // Adjust speed based on how far back the cue goes
        tempdX = (int) (Math.min(cue.distBall(), cue.getPullBackDist() - b.getRadius()) * Math.cos(cue.getAngle()) * -1);
        tempdY = (int) (Math.min(cue.distBall(), cue.getPullBackDist() - b.getRadius()) * Math.sin(cue.getAngle()) * -1);
        repaint();
    }

    /**
     * When mouse moved, rotate the cue accordingly to follow the mouse
     * Inspiration from:
     * https://www.instructables.com/Using-Java-to-Rotate-an-Object-to-Face-the-Mouse/
     * http://www.java2s.com/example/java/2d-graphics/draw-a-rotated-rectangle.html
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        // Find dist between the mouse and ball x and y components
        double Xd = mouseX - b.getX();
        double Yd = mouseY - b.getY();
        // Calculate the angle of the distance
        double radAngle = Math.atan(Yd/Xd);
        if (mouseX < b.getX()) {
            // Adjust angle to counteract arctan range restrictions
            radAngle = radAngle + Math.toRadians(180);
        }
        // Set angle of cue
        cue.setAngle(radAngle);
        repaint();

    }

    /**
     * Display OptionPane
     * @param infoMessage string to display in main box
     * @param titleBar title at the top of the box
     */
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.PLAIN_MESSAGE);
    }
}
