/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

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
 * @author teeyoshi
 */
public class BoardTest {
    
    public Logic logic;
    public JFrame frame;
    
    public BoardTest() {
    }

    @Before
    public void setUp() throws InterruptedException, FileNotFoundException, IOException {
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

    // BOARDIN TESTAUS
    // yli rajojen
    
    @Test
    public void boardInBoundsLeft(){
        logic.board.setX(0);
        logic.board.setDx(-logic.board.boardSpeed);
        logic.board.moveBoard();
        
        assertEquals("Board: x:", 0, logic.board.getX());
    }
    
    @Test
    public void boardInBoundsRight(){
        logic.board.setX(logic.ui.getWidth() - logic.board.boardWidth);
        logic.board.setDx(logic.board.boardSpeed);
        logic.board.moveBoard();
        
        assertEquals("Board: x:", logic.ui.getWidth() - logic.board.boardWidth, logic.board.getX());
    }
    
}
