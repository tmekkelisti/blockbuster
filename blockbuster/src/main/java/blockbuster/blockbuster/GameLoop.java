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

    /**
     * gameOver() tarkastaa jatkuvasti onko pallo pohjassa
     * moveAll() liikuttaa esineitä ruudulla
     * repaint() piirtää esineet uudestaan
     * hitDetection() tarkastaa jos tulee osumia esineille
     * sleep käytännössä kertoo pelin nopeuden (päivitystahdin)
     * 
     * @throws InterruptedException
     * @throws IOException 
     */

    public final void run() throws InterruptedException, IOException {
        while (isRunning) {
            logic.gameOver();
            logic.moveAll();
            logic.ui.repaint();
            logic.hitDetection();
            Thread.sleep(sleep);
        }
    }


}
