import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoolGame implements ActionListener {
    private PoolView window;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;
    private static final int SLEEP_TIME = 33;
    private Ball b;
    private Table table;
    private Cue cue;

    public PoolGame() {
        b = new Ball(200, 500 / 2 + 12, 12, Color.white, this);
        table = new Table(b, this);
        cue = new Cue(b);
        window = new PoolView(this);

    }

    public Ball getB() {
        return b;
    }


    public Table getTable() {
        return table;
    }


    public Cue getCue() {
        return cue;
    }


    public void start() {

    }

    public void end() {

    }

    public void run() {

    }

    public void actionPerformed(ActionEvent e) {
        //System.out.println("Hi");
        // Calculate velocity of the cue
        //b.bounceWall();;
        for (Ball ball : table.getBalls()) {
            ball.move();
        }
        b.move();
        table.checkPockets();
        table.checkWallCollisions();
        table.checkBallCollisions();
        //cue.resetPosition();
        window.repaint();
    }

    public static void main(String args[]) {
        PoolGame g = new PoolGame();
        Timer clock = new Timer(SLEEP_TIME, g);
        clock.start();


        // in your main() method, make sure to "turn on" mouse listener and mouse motion listener!!

        // Register the Mouse Listener and Mouse Motion Listener
    }
}
