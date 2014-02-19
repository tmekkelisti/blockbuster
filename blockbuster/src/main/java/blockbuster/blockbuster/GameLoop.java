package blockbuster.blockbuster;

import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * GameLoop-luokka huolehtii pelin päivittämisestä ja piirtämisestä
 */
public class GameLoop {

    int sleep = 2;
    boolean isRunning;
    Logic logic;


    public GameLoop(Logic logic) throws InterruptedException, IOException {
        this.isRunning = true;
        this.logic = logic;
        run();
    }


    public final void run() throws InterruptedException, IOException {
        while (isRunning) {
//            logic.blocksLeft();
            logic.gameOver();
            logic.moveAll();
            logic.ui.repaint();
//            ui_kokeilu.repaint();
//            ui_kokeilu.gamePanel.revalidate();
//            ui_kokeilu.gamePanel.repaint();
            logic.hitDetection();
            Thread.sleep(sleep);
        }
    }


}
