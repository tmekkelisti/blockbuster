/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blockbuster.blockbuster;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Teemu
 */
public class Board {
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

    public void moveBoard() {
        if (x + dx > 0 && x + dx < logic.ui.getWidth() - boardWidth) {
            x += dx;
        }

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
