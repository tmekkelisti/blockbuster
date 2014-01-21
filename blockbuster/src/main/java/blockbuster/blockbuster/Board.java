
package blockbuster.blockbuster;

import java.awt.Graphics2D;

public class Board {
    int x = 0;
    App blockbuster;

    public Board(App blockbuster) {
        this.blockbuster = blockbuster;
    }
    
    public void paint(Graphics2D board){
        board.fillRect(x, 530, 70, 10);
    }
}
