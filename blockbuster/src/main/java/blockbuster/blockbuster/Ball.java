package blockbuster.blockbuster;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Ball-luokka määrittelee pallon ja liikkumisen framen sisällä
 */
public class Ball {

    static final int RESET_STATE_X = 195;
    static final int RESET_STATE_Y = 520;
    static final int RESET_STATE_DX = 0;
    static final int RESET_STATE_DY = -1;
    
    private int x = 100;
    private int y = 50;
    private int dx = 1;
    private int dy = 1;
    int ballSize = 10;
    Logic logic;

    public Ball(Logic logic) {
        this.logic = logic;
    }

    /**
     * Liikuttaa ja kimmottelee palloa pelilaudan puitteissa
     */
    public boolean moveBall() {
        if (x + dx < 0) {
            dx = 1;
        }
        if (x + dx > logic.ui.getWidth() - ballSize) {
            dx = -1;
        }
        if (y + dy < 0) {
            dy = 1;
        }
        if (y + dy > logic.ui.getHeight() - ballSize) {
            dy = -1;
        }

        x += dx;
        y += dy;

        return true;
    }

    /**
     * Palauttaa pallon Rectanglen hitDetectioniin
     *
     * @return
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, ballSize, ballSize);
    }

    public void paint(Graphics ball) {
        ball.fillOval(x, y, ballSize, ballSize);
    }

    /**
     * Asettaa pallon pelilaudan keskelle laudan korkeudelle
     */
    public boolean resetBall() {
        this.y = RESET_STATE_Y;
//        this.x = (logic.ui.getWidth() / 2) - (this.ballSize / 2);
        this.x = RESET_STATE_X;
        this.dy = RESET_STATE_DY;
        this.dx = RESET_STATE_DX;
        
        return true;
    }
    
    public void moveBallRight() {
        this.x += 2;
    }
    
    public void moveBallLeft(){
        this.x += -2; 
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public boolean stopBall() {
        this.dx = 0;
        this.dy = 0;
        return true;
    }
}
