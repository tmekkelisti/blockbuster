package blockbuster.blockbuster;

import java.awt.Graphics;

public class Ball {

    private int x = 200;
    private int y = 5;
    private int dx = 0;
    private int dy = -1;
    int ballSize = 30;
    App blockbuster;

    public Ball(App blockbuster) {
        this.blockbuster = blockbuster;
    }

    public void moveBall() {
        if (x + dx < 0) {
            dx = 1;
        }
        if (x + dx > blockbuster.getWidth() - ballSize) {
            dx = -1;
        }
        if (y + dy < 0) {
            dy = 1;
        }
        if (y + dy > blockbuster.getHeight() - ballSize) {
            dy = -1;
        }

        x += dx;
        y += dy;

        //System.out.println(x + ", " + y + "|" + dy);
        
    }

    public void paint(Graphics ball) {
        ball.fillOval(x, y, ballSize, ballSize);
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
