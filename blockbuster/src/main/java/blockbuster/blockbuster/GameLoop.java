/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

/**
 *
 * @author teeyoshi@cs
 */
public class GameLoop{
    boolean isRunning;
    App bb;

    public GameLoop(App bb) throws InterruptedException {
        this.isRunning = true;
        this.bb = bb;
        run();
    }

    public final void run() throws InterruptedException{
        while(isRunning){
            bb.animate();
            bb.repaint();
            bb.hitDetection();
            Thread.sleep(3);
        }
    }
    
}
