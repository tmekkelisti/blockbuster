
package blockbuster.blockbuster;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Board-luokka handlaa laudan ja sen liikkumisen
 */
public class Board {
    
    static final int RESET_STATE_X = 165;
    
    int x = 0;
    int y = 530;
    int dx = 0;
    int boardHeight = 10;
    int boardWidth = 70;
    int boardSpeed = 2;

    Logic logic;
    

    public Board(Logic logic) {
        this.logic = logic;

    }

    public void paint(Graphics2D board) {
        board.fillRect(x, y, boardWidth, boardHeight);
    }
    
    /**
     * Liikuttaa lautaa pelilaudan puitteissa
     */

    public boolean moveBoard() {
        if (x + dx > 0 && x + dx < logic.ui.getWidth() - boardWidth) {
            x += dx;
        }

        return true;
    }

    public void moveLeft(){
        setDx(-boardSpeed);
    }
    
    public void moveRight(){
        setDx(boardSpeed);
    }
    
    public void stopMoving(){
        setDx(0);
    }
    
    /**
     * Asettaa laudan keskelle pelilautaa
     * @return 
     */
    
    public boolean resetBoard(){
//        this.x = (logic.ui.getWidth() / 2) - (this.boardWidth / 2);
        this.x = RESET_STATE_X;
        return true;
    }
    
    /**
     * Palauttaa laudan Rectanglen
     * @return 
     */
    
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
