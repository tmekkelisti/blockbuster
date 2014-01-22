package blockbuster.blockbuster;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JPanel {

    Board board = new Board(this);
    Ball ball = new Ball(this);

    public App() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                board.keyPressed(ke);
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                board.keyReleased(ke);
            }
        });
        setFocusable(true);
    }
  

    public static void main(String[] args) throws InterruptedException {
        JFrame lauta = new JFrame("BLOCKBUSTER");
        App blockbuster = new App();
        lauta.add(blockbuster);

        lauta.setSize(400, 600);
        lauta.setVisible(true);
        lauta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            blockbuster.animate();
            blockbuster.repaint();
            Thread.sleep(10);
        }

    }

    public void animate() {
        ball.moveBall();
        board.moveBoard();
    }

    @Override
    public void paint(Graphics gfx) {
        super.paint(gfx);
        Graphics2D g2d = (Graphics2D) gfx;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        board.paint(g2d);
    }

}
