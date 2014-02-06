/**
 * UI luokka huolehtii piirtämisestä ja näppäinten kuuntelusta
 */
package blockbuster.blockbuster;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UI extends JPanel implements KeyListener {

    static final int UI_WIDTH = 400;
    static final int UI_HEIGHT = 600;

    Logic logic;

    public UI(Logic logic) {
        this.logic = logic;
        setFocusable(true);
        requestFocus();
        addKeyListener(this);

    }
    
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString("LIVES: " + logic.lives, 10, 565);
        g2d.drawString("LAUNCH BALL: 'SPACE'", 70, 565);
        g2d.drawString("RESTART: 'ENTER'", 270, 565);
        
        
        
        logic.ball.paint(g2d);
        logic.board.paint(g2d);
        
        for (Block block : logic.blocks) {
            if (!block.isDestroyed()) {
                block.paint(g2d);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        logic.keyTyped(ke.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        logic.keyPressed(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        logic.keyReleased(ke.getKeyCode());
    }


}
