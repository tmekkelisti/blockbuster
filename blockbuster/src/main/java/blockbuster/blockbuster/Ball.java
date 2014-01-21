package blockbuster.blockbuster;

import java.awt.Graphics;

public class Ball {

    int x = 0;
    int y = 0;
    int directionX = 1;
    int directionY = 1;
    App blockbuster;

    public Ball(App blockbuster) {
        this.blockbuster = blockbuster;
    }
    
    

    public void moveBall() {
        if(x + directionX < 0){
            directionX = 1;
        } if(x + directionX > blockbuster.getWidth() - 15){
            directionX = -1;
        } if(y + directionY < 0){
            directionY = 1;
        } if(y + directionY > blockbuster.getHeight() - 15){
            directionY = -1;
        }
        
        x += directionX;
        y += directionY;
        
    }

    public void paint(Graphics ball) {
        ball.fillOval(x, y, 15, 15);
    }

}
