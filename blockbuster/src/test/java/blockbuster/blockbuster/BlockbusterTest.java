/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockbuster.blockbuster;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teemu
 */
public class BlockbusterTest {

    public App blockbuster;
    public Ball ball;
    public Board board;

    public BlockbusterTest() {
    }

    @Before
    public void setUp() {
        blockbuster = new App();
        ball = new Ball(blockbuster);
        board = new Board(blockbuster);

        JFrame lauta = new JFrame("BLOCKBUSTER");
        lauta.add(blockbuster);
        lauta.setSize(400, 600);
        lauta.setVisible(true);
        lauta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setBall(int x, int y, int dx, int dy) {
        ball.setX(x);
        ball.setY(y);
        ball.setDx(dx);
        ball.setDy(dy);
    }

    // PALLON TESTAUS
    // pallo ei liiku yli rajojen
    @Test
    public void ballInBoundsTop() {
        setBall(0, 0, 0, -1);
        ball.moveBall();

        assertEquals("Ball: y:", 1, ball.getY());
        assertEquals("Ball: dy:", 1, ball.getDy());

    }

    @Test
    public void BallInBoundsBottom() {
        setBall(0,blockbuster.getHeight() - ball.ballSize, 0, 1);
        ball.moveBall();
        
        assertEquals("Ball: y:", blockbuster.getHeight() - ball.ballSize - 1, ball.getY());
        assertEquals("Ball: dy:", -1, ball.getDy());
        
    }

    @Test
    public void BallInBoundsLeft() {
        setBall(0, 0, -1, 0);
        ball.moveBall();
        
        assertEquals("Ball: x:", 1, ball.getX());
        assertEquals("Ball: dx:", 1, ball.getDx());
    }
    
    @Test
    public void BallInBoundsRight(){
        setBall(blockbuster.getWidth() - ball.ballSize, 0, 1, 0);
        ball.moveBall();
        
        assertEquals("Ball: x:", blockbuster.getWidth() - ball.ballSize - 1, ball.getX());
        assertEquals("Ball: dx:", -1, ball.getDx());
    }
    
    // BOARDIN TESTAUS
    // yli rajojen
    
    @Test
    public void BoardInBoundsLeft(){
        board.setX(0);
        board.setDx(-board.boardSpeed);
        board.moveBoard();
        
        assertEquals("Board: x:", 0, board.getX());
    }
    
    @Test
    public void BoardInBoundsRight(){
        board.setX(blockbuster.getWidth() - board.boardSize);
        board.setDx(board.boardSpeed);
        board.moveBoard();
        
        assertEquals("Board: x:", blockbuster.getWidth() - board.boardSize, board.getX());
    }
    
}
