package blockbuster.blockbuster;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
        JFrame frame = new JFrame("BLOCKBUSTER");
        App blockbuster = new App();
        frame.add(blockbuster);

        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            blockbuster.animate();
            blockbuster.repaint();
            blockbuster.hitDetection();
            Thread.sleep(15);
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
        
        g2d.drawString("HIT: " + hitDetection(), 5, 15);
        
        ball.paint(g2d);
        board.paint(g2d);
    }
    
    public boolean hitDetection(){

        if(ball.getBounds().intersects(board.getBounds())){
            return true;
        }else{
            return false;
        }
    }
    

}
