import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Menlo School CS2 Final Project
 * Pool aiming practice
 * Game class (backend)
 * @author isabelprado
 * @version 5/12/23
 */
public class PoolGame implements ActionListener {
    // Instance variables
    private PoolView window;
    private Ball b;
    private Table table;
    private Cue cue;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;
    private static final int SLEEP_TIME = 33;

    /**
     * Constructor
     * Creates game elements
     */
    public PoolGame() {
        b = new Ball(200, 500 / 2 + 12, 12, this);
        table = new Table(b, this);
        cue = new Cue(b);
        window = new PoolView(this);
    }

    /**
     * Getters and setter methods
     */
    public Ball getB() {
        return b;
    }


    public Table getTable() {
        return table;
    }


    public Cue getCue() {
        return cue;
    }

    /**
     * End game: closes the window and displays message that the player won
     */
    public void end() {
        window.setVisible(false);
        window.infoBox("Congrats! You completed the game.", "PoolGame");
    }

    /**
     * actionPerformed
     * executes every SLEEP_TIME milliseconds
     * moves the ball, tracks wall collisions and pockets
     * Determines which pocket to turn color
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        b.move();
        b.bounceWall();
        // Check if the ball is in a pocket
        table.checkPockets();
        // Pseudorandom switching of the pockets
        Date currentDate = new Date();
        if (currentDate.getTime() % 100 == 0) {
            table.switchPocket();
        }
        // Repaint window to reflect new movement and colors
        window.repaint();
    }

    public static void main(String args[]) {
        PoolGame g = new PoolGame();
        Timer clock = new Timer(SLEEP_TIME, g);
        clock.start();

    }
}
