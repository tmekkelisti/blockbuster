package blockbuster.blockbuster;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Board {

    int x = 0;
    int dx = 0;
    App blockbuster;

    public Board(App blockbuster) {
        this.blockbuster = blockbuster;
    }

    public void paint(Graphics2D board) {
        board.fillRect(x, 530, 70, 10);
    }

    public void moveBoard() {
        if (x + dx > 0 && x + dx < blockbuster.getWidth() - 70) {
            x += dx;
        }

    }

    void keyReleased(KeyEvent ke) {
        dx = 0;
    }

    void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -2;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }
}
