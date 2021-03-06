/**
 * UI luokka huolehtii piirtämisestä ja näppäinten kuuntelusta
 */
package blockbuster.UI;

import blockbuster.blockbuster.Block;
import blockbuster.blockbuster.Logic;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Hoitaa piirtämisen esineiden luokkien metodien avulla.
     * Tekstit ovat drawStringeillä jotka saavat logicilta tiedot
     * 
     * Jos peli on voitettu ja nopein aika on tehty, ruutuun ilmestyy myös 
     * entinen "highScore" ja onnittelu teksti
     * @param g 
     */
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawString("LIVES: " + logic.lives, 10, 35);
        g2d.drawString("restart: 'ENTER'", 270, 20);
        try {
            g2d.drawString("BLOCKS LEFT: " + logic.blocksLeft(), 10, 20);
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2d.drawString(logic.info, 15, 555);
        g2d.drawString("TIME: " + logic.timeString(), 270, 35);

        logic.ball.paint(g2d);
        logic.board.paint(g2d);

        for (Block block : logic.blocks) {
            if (!block.isDestroyed()) {
                block.paint(g2d);
            }
        }

        if (logic.gameFinished && logic.gameFinishedWIN) {
            g2d.drawString("GAME OVER", 125, 300);
            g2d.drawString("YOUR TIME:         " + logic.stopWatch.getTime(), 125, 330);

                g2d.drawString("GAME RECORD: " + logic.highScore, 125, 345);
                if(logic.stopWatch.getTime() < logic.highScore){
                    g2d.drawString("CONGRATS! A NEW RECORD!", 125, 375);
                }
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        logic.keyTyped(ke.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        try {
            logic.keyPressed(ke.getKeyCode());
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        logic.keyReleased(ke.getKeyCode());
    }

}
