
package blockbuster.blockbuster;

import javax.swing.JFrame;

public class Blockbuster {


    JFrame frame;
    Logic logic;
    GameLoop loop;
    

    public Blockbuster() throws InterruptedException {
        logic = new Logic();
        frame = new JFrame("TESTINGI OUT");

        frame.setSize(400, 600);
        frame.getContentPane().add(logic.ui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        loop = new GameLoop(logic);
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
        Blockbuster game = new Blockbuster();
    }
    
}
