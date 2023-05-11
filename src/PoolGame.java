import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PoolGame implements ActionListener {
    private PoolView window;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;
    private static final int SLEEP_TIME = 33;
    private Ball b;
    private Table table;
    private Cue cue;

    public PoolGame() {
        b = new Ball(200, 500 / 2 + 12, 12, this);
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

    public void end() {
        window.setVisible(false);
        window.infoBox("Congrats! You completed the game.", "PoolGame");
    }

    public void actionPerformed(ActionEvent e) {
        b.move();
        table.checkPockets();
        table.checkWallCollision();
        Date currentDate = new Date();
        if (currentDate.getTime() % 100 == 0) {
            table.switchPocketColors();
        }
        window.repaint();
    }

    public static void main(String args[]) {
        PoolGame g = new PoolGame();
        Timer clock = new Timer(SLEEP_TIME, g);
        clock.start();

    }
}
