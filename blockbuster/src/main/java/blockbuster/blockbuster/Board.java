package blockbuster.blockbuster;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board {

    int x = 0;
    int y = 530;
    int dx = 0;
    int boardHeight = 10;
    int boardWidth = 70;
    int boardSpeed = 2;
    App blockbuster;
    

    public Board(App blockbuster) {
        this.blockbuster = blockbuster;

    }

    public void paint(Graphics2D board) {
        board.fillRect(x, y, boardWidth, boardHeight);
    }

    public void moveBoard() {
        if (x + dx > 0 && x + dx < blockbuster.getWidth() - boardWidth) {
            x += dx;
        }

    }

    void keyReleased(KeyEvent ke) {
        dx = 0;
        
    }

    void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -boardSpeed;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = boardSpeed;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, boardWidth, boardHeight);
    }

    public int getX() {
        return x;
    }

    public int getDx() {
        return dx;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }
    
    
    
}
