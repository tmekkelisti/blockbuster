/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Teemu
 */
public class Ball {
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

    public void moveBall() {
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


        
    }
    
    /**
     * Palauttaa pallon Rectanglen hitDetectioniin
     * @return 
     */

    public Rectangle getBounds(){
        return new Rectangle(x,y,ballSize,ballSize);
    }
    
    public void paint(Graphics ball) {
        ball.fillOval(x, y, ballSize, ballSize);
    }
    
    /**
     * Asettaa pallon pelilaudan keskelle laudan korkeudelle
     */
    
    public void resetBall(){
        this.y = 520;
//        this.x = (logic.ui.getWidth() / 2) - (this.ballSize / 2);
        this.x = 195;
        this.dy = -1;
        this.dx = 0;
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
}
