/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teeyoshi
 */
public class BallTest {
    
    public Logic logic;
    public Ball ball;
    public Board board;
    JFrame frame;
    
    public BallTest() {
    }
    

    @Before
    public void setUp() throws InterruptedException {
        logic = new Logic();
        ball = new Ball(logic);
        board = new Board(logic);

        logic = new Logic();
        frame = new JFrame("TESTINGI OUT");

        frame.setSize(400, 600);
        frame.getContentPane().add(logic.ui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

//        JFrame frame = new JFrame("BLOCKBUSTER");
//        frame.add(blockbuster);
//        frame.setSize(400, 600);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void setBall(int x, int y, int dx, int dy) {
        ball.setX(x);
        ball.setY(y);
        ball.setDx(dx);
        ball.setDy(dy);
    }

    // PALLON TESTAUS
    // pallo ei liiku yli rajojen
//    @Test
//    public void ballInBoundsTop() {
//        setBall(0, 0, 0, -1);
//        ball.moveBall();
//
//        assertEquals("Ball: y:", 1, ball.getY());
//        assertEquals("Ball: dy:", 1, ball.getDy());
//
//    }

    @Test
    public void ballInBoundsBottom() {
        setBall(0,logic.ui.getHeight() - ball.ballSize, 0, 1);
        ball.moveBall();
        
        assertEquals("Ball: y:", logic.ui.getHeight() - ball.ballSize - 1, ball.getY());
        assertEquals("Ball: dy:", -1, ball.getDy());
        
    }

//    @Test
//    public void ballInBoundsLeft() {
//        setBall(0, 0, -1, 0);
//        ball.moveBall();
//        
//        assertEquals("Ball: x:", 1, ball.getX());
//        assertEquals("Ball: dx:", 1, ball.getDx());
//    }
    
    @Test
    public void ballInBoundsRight(){
        setBall(logic.ui.getWidth() - ball.ballSize, 0, 1, 0);
        ball.moveBall();
        
        assertEquals("Ball: x:", logic.ui.getWidth() - ball.ballSize - 1, ball.getX());
        assertEquals("Ball: dx:", -1, ball.getDx());
    }

}
