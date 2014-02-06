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
    JFrame frame;
    
    public BallTest() {
    }
    

    @Before
    public void setUp() throws InterruptedException {

        logic = new Logic();
        frame = new JFrame("TESTINGI OUT");
        frame.setSize(400, 600);
        frame.getContentPane().add(logic.ui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void setBall(int x, int y, int dx, int dy) {
        logic.ball.setX(x);
        logic.ball.setY(y);
        logic.ball.setDx(dx);
        logic.ball.setDy(dy);
    }

//     PALLON TESTAUS
//     pallo ei liiku yli rajojen
    @Test
    public void ballInBoundsTop() {
        setBall(0, 0, 0, -1);
        logic.ball.moveBall();

        assertEquals("Ball: y:", 1, logic.ball.getY());
        assertEquals("Ball: dy:", 1, logic.ball.getDy());

    }

    @Test
    public void ballInBoundsBottom() {
        setBall(0,logic.ui.getHeight() - logic.ball.ballSize, 0, 1);
        logic.ball.moveBall();
        
        assertEquals("Ball: y:", logic.ui.getHeight() - logic.ball.ballSize - 1, logic.ball.getY());
        assertEquals("Ball: dy:", -1, logic.ball.getDy());
        
    }

    @Test
    public void ballInBoundsLeft() {
        setBall(0, 0, -1, 0);
        logic.ball.moveBall();
        
        assertEquals("Ball: x:", 1, logic.ball.getX());
        assertEquals("Ball: dx:", 1, logic.ball.getDx());
    }
    
    @Test
    public void ballInBoundsRight(){
        setBall(logic.ui.getWidth() - logic.ball.ballSize, 0, 1, 0);
        logic.ball.moveBall();
        
        assertEquals("Ball: x:", logic.ui.getWidth() - logic.ball.ballSize - 1, logic.ball.getX());
        assertEquals("Ball: dx:", -1, logic.ball.getDx());
    }

}
