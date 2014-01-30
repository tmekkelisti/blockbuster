/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 *
 * @author Teemu
 */
public class UI implements Runnable{

    App blockbuster;
    JFrame ui = new JFrame("BLOCKBUSTERRR");
    boolean isRunning;
    
    
    public UI(App blockbuster) {
        this.blockbuster = blockbuster;
        this.isRunning = true;
        this.ui.setSize(400, 600);
        this.ui.setVisible(true);
        this.ui.setResizable(false);
        this.ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    
    @Override
    public void run() {
        while(isRunning){
            blockbuster.animate();
            blockbuster.repaint();
            blockbuster.hitDetection();            
        }

    }
    
    
    
}
