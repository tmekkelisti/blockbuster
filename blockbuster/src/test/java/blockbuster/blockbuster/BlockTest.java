/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

import java.io.FileNotFoundException;
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
public class BlockTest {
    
    public Logic logic;
    public JFrame frame;
    
    public BlockTest() {
    }

    @Before
    public void setUp() throws InterruptedException, FileNotFoundException {
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
    
    @Test
    public void blockDestroyed(){
        Block block = new Block(5,5);
        block.setDestroyed(true);
        assertEquals("Block out of bounds:x", 400, block.x);
        assertEquals("Block out of bounds:y", 600, block.y);
        assertEquals("isDestroyed to false", true, block.isDestroyed());
        
    }

    
    
    
}
