
package blockbuster.blockbuster;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Blockbuster {


    JFrame frame;
    Logic logic;
    GameLoop loop;
    UI_kokeilu kokeilu;

    public Blockbuster() throws InterruptedException {
        logic = new Logic();
 
//        final UI_kokeilu kokeilu = new UI_kokeilu(logic);
//
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run(){
//                kokeilu.luoUI();
//                kokeilu.setVisible(true);
//            }
//        }
//        );
        
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
