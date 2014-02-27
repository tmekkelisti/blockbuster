
package blockbuster.blockbuster;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class Blockbuster {

    JFrame frame;
    Logic logic;
    GameLoop loop;

    public Blockbuster() throws InterruptedException, FileNotFoundException, IOException {
        logic = new Logic();       
        frame = new JFrame("BLOCKBUSTERrr");
        frame.setSize(400, 600);
        frame.getContentPane().add(logic.ui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        loop = new GameLoop(logic);
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        Blockbuster game = new Blockbuster();
    }
    
}
