/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockbuster.blockbuster;

import java.awt.event.KeyEvent;

/**
 *
 * @author Teemu
 */
public class GameLoop {

    int sleep = 2;
    boolean isRunning;
    Logic logic;

    public GameLoop(Logic logic) throws InterruptedException {
        this.isRunning = true;
        this.logic = logic;
        run();
    }


    public final void run() throws InterruptedException {
        while (isRunning) {
            logic.moveAll();
            logic.ui.repaint();
            logic.hitDetection();
            Thread.sleep(sleep);
        }
    }

    public void setRunning(boolean set) {
        this.isRunning = set;
    }

}
