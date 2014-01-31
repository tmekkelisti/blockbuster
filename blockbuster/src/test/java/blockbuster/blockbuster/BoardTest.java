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
public class BoardTest {
    
    public Logic logic;
    public Ball ball;
    public Board board;
    public JFrame frame;
    
    public BoardTest() {
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
        
    }

    public void setBall(int x, int y, int dx, int dy) {
        ball.setX(x);
        ball.setY(y);
        ball.setDx(dx);
        ball.setDy(dy);
    }

    // BOARDIN TESTAUS
    // yli rajojen
    
    @Test
    public void boardInBoundsLeft(){
        board.setX(0);
        board.setDx(-board.boardSpeed);
        board.moveBoard();
        
        assertEquals("Board: x:", 0, board.getX());
    }
    
    @Test
    public void boardInBoundsRight(){
        board.setX(logic.ui.getWidth() - board.boardWidth);
        board.setDx(board.boardSpeed);
        board.moveBoard();
        
        assertEquals("Board: x:", logic.ui.getWidth() - board.boardWidth, board.getX());
    }
    
}
