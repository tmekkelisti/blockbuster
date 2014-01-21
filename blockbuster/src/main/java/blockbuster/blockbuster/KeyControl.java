package blockbuster.blockbuster;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyControl {

    public KeyControl() {
        KeyListener listener = new KeyListener() {

            @Override
            public void keyPressed(KeyEvent ke) {
                ke.getKeyCode();
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                ke.getKeyCode();
            }

            @Override
            public void keyTyped(KeyEvent ke) {

            }
        };

    }

}
