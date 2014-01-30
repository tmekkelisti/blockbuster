package blockbuster.blockbuster;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyControl implements KeyListener{


    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println(KeyEvent.getKeyText(ke.getKeyCode()));
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
