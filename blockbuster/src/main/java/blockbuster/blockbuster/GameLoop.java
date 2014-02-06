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
