import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PoolGame {
    private PoolView view;
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 800;

    public PoolGame() {
    }

    public void oneMove(Player p) {

    }

    public void start() {

    }

    public void end() {

    }

    public void run() {

    }

    public static void main(String args[]) {
        PoolView window = new PoolView();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setVisible(true);
        window.createBufferStrategy(2);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.repaint();


        // in your main() method, make sure to "turn on" mouse listener and mouse motion listener!!

        // Register the Mouse Listener and Mouse Motion Listener
        window.addMouseListener(window);
        window.addMouseMotionListener(window);

        window.repaint();
    }
}
