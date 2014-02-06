/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author teeyoshi@cs
 */
public class GamePanel extends JPanel{

    Logic logic;
    
    public GamePanel(Logic logic) {
        this.logic = logic;
        setPreferredSize(new Dimension(400, 600));
    }
    
        @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        logic.ball.paint(g2d);
        logic.board.paint(g2d);

        for (Block block : logic.blocks) {
            if (!block.isDestroyed()) {
                block.paint(g2d);
            }
        }
        

    }
}
