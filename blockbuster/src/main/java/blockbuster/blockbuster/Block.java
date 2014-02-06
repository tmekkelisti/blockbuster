package blockbuster.blockbuster;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Block luokka määrittelee blockien sijainnit ja hajoamisen
 */
public class Block {
    int x;
    int y;
    int blockHeight = 10;
    int blockWidth = 50;
    boolean destroyed;
   

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.destroyed = false;
    }
    
    public void paint(Graphics2D block) {
        block.fillRect(x, y, blockWidth, blockHeight);
        
    }

    public void setDestroyed(boolean destroyed) {
        x = 400;        //pelialueen ulkopuolelle
        y = 600;        //pelialueen ulkopuolelle
        this.destroyed = destroyed;
    }

    public boolean isDestroyed(){
        return destroyed;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, blockWidth, blockHeight);
    }
}
