package blockbuster.blockbuster;

import java.awt.Graphics;

public class Ball {

    int x = 0;
    int y = 0;
    int dx = 1;
    int dy = 1;
    App blockbuster;

    public Ball(App blockbuster) {
        this.blockbuster = blockbuster;
    }

    public void moveBall() {
        if (x + dx < 0) {
            dx = 1;
        }
        if (x + dx > blockbuster.getWidth() - 15) {
            dx = -1;
        }
        if (y + dy < 0) {
            dy = 1;
        }
        if (y + dy > blockbuster.getHeight() - 15) {
            dy = -1;
        }

        x += dx;
        y += dy;

    }

    public void paint(Graphics ball) {
        ball.fillOval(x, y, 15, 15);
    }

}
