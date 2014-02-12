package blockbuster.blockbuster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teeyoshi@cs
 */
public class LogicTest {
    
    public Logic logic;
    public Ball ball;
    public Board board;
    JFrame frame;
    GameLoop loop;
    
    public LogicTest() {
    }
    

    @Before
    public void setUp() throws InterruptedException {
        ball = new Ball(logic);
        board = new Board(logic);

        logic = new Logic();
        frame = new JFrame("TESTINGI OUT");

        frame.setSize(400, 600);
        frame.getContentPane().add(logic.ui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //loop = new GameLoop(logic);
        
    }
    
    public void setBall(int x, int y, int dx, int dy) {
        logic.ball.setX(x);
        logic.ball.setY(y);
        logic.ball.setDx(dx);
        logic.ball.setDy(dy);
    }
    
    @Test
    public void hitDetectedtoBlock(){
        logic.createBlocks();
        setBall(17, 260, 0, -1);
        logic.ball.moveBall();
        
        assertEquals("hitToBlock: ", true, logic.hitDetection());
    }
    
    @Test
    public void hitDetectedtoBoard(){
        setBall(logic.board.x, logic.board.y, 0, 1);
        logic.ball.moveBall();
        
        assertEquals("hitToBoard: ", true, logic.hitDetection());
    }
    
    @Test
    public void checkLivesChecks(){
        logic.lives = 2;
        logic.checkLives();
        logic.checkLives();
        
        assertEquals("lives: ", 0, logic.lives);
    }
    
    
    @Test
    public void gameOverChecks(){
        logic.lives = 1;
        logic.setPause(false);
        setBall(0, logic.ui.getHeight() - 10, 0, 1);

        assertTrue(logic.gameOver());
//        assertEquals("lives: ", true, logic.gameOver());

        
    }

}
