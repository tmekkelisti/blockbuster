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
public class BlockTest {
    
    public App blockbuster;
    public Ball ball;
    
    public BlockTest() {
    }

    @Before
    public void setUp() throws InterruptedException {
        blockbuster = new App();
        ball = new Ball(blockbuster);

        JFrame frame = new JFrame("BLOCKBUSTER");
        frame.add(blockbuster);
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    public void setBall(int x, int y, int dx, int dy) {
        ball.setX(x);
        ball.setY(y);
        ball.setDx(dx);
        ball.setDy(dy);
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
