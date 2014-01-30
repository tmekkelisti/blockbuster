package blockbuster.blockbuster;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App extends JPanel {

    Board board;    // = new Board(this);
    Ball ball;      // = new Ball(this);
    Timer timer;
    Block[] blocks;
    GameLoop loop;
    

    public App() throws InterruptedException {
 

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
        init();
    }
  

    public static void main(String[] args) throws InterruptedException {
        
//        SwingUtilities.invokeLater(new UI(new App()));
        
        JFrame frame = new JFrame("BLOCKBUSTER");
        App blockbuster = new App();
        frame.add(blockbuster);

        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blockbuster.loop = new GameLoop(blockbuster);
//        
//        frame.addKeyListener(new KeyControl());

    }


    public void init() throws InterruptedException{
//        loop = new GameLoop(this);
        createBlocks();
        ball = new Ball(this);
        board = new Board(this);
//        keyControl = new KeyControl();
//        addKeyListener(keyControl);
//        setFocusable(true);
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
        
//        g2d.drawString("HIT: " + hitDetection(), 5, 15);
        
        ball.paint(g2d);
        board.paint(g2d);

        for (Block block : blocks) {
            if (!block.isDestroyed()) {
                block.paint(g2d);
            }
        }
    }
    
    
    
    public void hitDetection(){
        if(ball.getBounds().intersects(board.getBounds())){
            boardCollision();
        }else{
            for(Block block : blocks) {
                if (ball.getBounds().intersects(block.getBounds())){
                    blockCollision(block);
                    break;
                }
            }
        }
    }
    
    public void boardCollision(){
        
            ball.setDy(-1);
        
    }
    
    public void blockCollision(Block block){
        
        int ballLeft = ball.getX();
        int ballHeight = (int)ball.getBounds().getHeight();
        int ballWidth = (int)ball.getBounds().getWidth();
        int ballTop = ball.getY();
        
        Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
        Point pointLeft = new Point(ballLeft - 1, ballTop);
        Point pointTop = new Point(ballLeft, ballTop - 1);
        Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
        
        if(block.getBounds().contains(pointBottom)){
            ball.setDy(-1);
        }
        if(block.getBounds().contains(pointTop)){
            ball.setDy(1);
        }
        if(block.getBounds().contains(pointLeft)){
            ball.setDx(1);
        }
        if(block.getBounds().contains(pointRight)){
            ball.setDx(-1);
        }
        
        block.setDestroyed(true);
    }
    
    
    
    private void createBlocks(){
        blocks = new Block[4];
        blocks[0] = new Block(5, 50);
        blocks[1] = new Block(250, 50);
        blocks[2] = new Block(5, 65);
        blocks[3] = new Block(250, 65);
    }

    
    

}
