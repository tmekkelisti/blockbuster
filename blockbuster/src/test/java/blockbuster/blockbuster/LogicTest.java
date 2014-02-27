package blockbuster.blockbuster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
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
    JFrame frame;
    GameLoop loop;
    
    public LogicTest() {
    }
    

    @Before
    public void setUp() throws InterruptedException, FileNotFoundException, IOException {
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
    public void hitDetectedtoBlock() throws IOException{
        logic.createBlocks();
        setBall(17, 260, 0, -1);
        logic.ball.moveBall();
        
        assertEquals("hitToBlock: ", true, logic.hitDetection());
    }
    
    @Test
    public void hitDetectedtoBoard() throws IOException{
        setBall(logic.board.x, logic.board.y, 0, 1);
        logic.ball.moveBall();
        
        assertEquals("hitToBoard: ", true, logic.hitDetection());
    }
    
    @Test
    public void checkLivesWithRemainingLives() throws IOException{
        logic.lives = 2;
        logic.checkRemainingLives();
        logic.checkRemainingLives();
        
        assertEquals("lives: ", 0, logic.lives);
    }
    
    public void checkLivesWithoutLives() throws IOException{
        logic.lives = 0;
        logic.checkRemainingLives();
        
        assertEquals("GAME OVER!", logic.getInfo());
        assertEquals(0, logic.ball.getDx());
        assertEquals(0, logic.ball.getDy());
    }
    
    @Test
    public void gameOverChecks() throws IOException{
        logic.lives = 1;
        logic.setPause(false);
        setBall(0, logic.ui.getHeight() - 10, 0, 1);

        assertTrue(logic.gameOver());
        assertTrue(logic.isPause());
        assertEquals(0, logic.lives);
        assertEquals(logic.ball.RESET_STATE_X, logic.ball.getX());
        assertEquals(logic.ball.RESET_STATE_Y, logic.ball.getY());
        assertEquals(logic.ball.RESET_STATE_DX, logic.ball.getDx());
        assertEquals(logic.ball.RESET_STATE_DY, logic.ball.getDy());
        assertEquals(logic.board.RESET_STATE_X, logic.board.getX());
        assertTrue(logic.ball.resetBall());
        assertTrue(logic.board.resetBoard());
    }
    
    @Test
    public void notGameOverCheck() throws IOException{
        setBall(50, 300, 0, 1);
        assertFalse(logic.gameOver());
    }
    
    @Test
    public void blockLeftChecks() throws IOException{
        logic.createBlocks();
        for (int i = 0; i < logic.blocks.length; i++) {
            logic.blocksLeft--;
        }
        
        assertEquals(0, logic.blocksLeft());
        assertTrue(logic.isPause());
 
    }
    
    @Test
    public void startGame() throws IOException{
        logic.startGame();
        
        assertTrue(logic.isPause());
        assertEquals(logic.ball.RESET_STATE_X, logic.ball.getX());
        assertEquals(logic.ball.RESET_STATE_Y, logic.ball.getY());
        assertEquals(logic.ball.RESET_STATE_DX, logic.ball.getDx());
        assertEquals(logic.ball.RESET_STATE_DY, logic.ball.getDy());
        assertEquals(logic.board.RESET_STATE_X, logic.board.getX());
        assertEquals(logic.LIVES_AT_START, logic.lives);
        assertTrue(logic.ball.resetBall());
        assertTrue(logic.board.resetBoard());
        assertTrue(logic.startGame());
        assertEquals(42, logic.blocksLeft());
        assertEquals("press 'SPACEBAR' to launch!", logic.getInfo());
    }

    @Test
    public void boardLeftCollision() throws IOException{
        setBall(logic.board.getX(), logic.board.y, 0, 1);
        logic.moveAll();
        logic.hitDetection();
        
        assertEquals(-1, logic.ball.getDx());
        assertEquals(-1, logic.ball.getDy());
    }
    
    @Test
    public void boardRightCollision() throws IOException{
        setBall(logic.board.getX() + 40, logic.board.y, 0, 1);
        logic.moveAll();
        logic.hitDetection();
        
        assertEquals(1, logic.ball.getDx());
        assertEquals(-1, logic.ball.getDy());
    }
    
    @Test
    public void initInitializes() throws InterruptedException, IOException{
        assertNotNull(logic.board);
        assertNotNull(logic.ball);
        assertNotNull(logic.ui);
        startGame();
    }
    
    @Test
    public void moveAllMoves() throws IOException{
        logic.setPause(false);
        logic.moveAll();
        
        assertTrue(logic.ball.moveBall());
        assertTrue(logic.board.moveBoard());
        assertEquals(" ", logic.getInfo());
    }
    
    
    
}
