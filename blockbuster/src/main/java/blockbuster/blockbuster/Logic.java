package blockbuster.blockbuster;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 *
 * @author Teemu
 */
public class Logic {

    Ball ball;
    Board board;
    Block[] blocks;
    UI ui;


    public Logic() throws InterruptedException {
        init();
    }
    
    public void init() throws InterruptedException{
        ball = new Ball(this);
        board = new Board(this);
        ui = new UI(this);
        createBlocks();
    }
    
    void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                board.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                board.moveRight();
                break;
        }
    }

    void keyTyped(char keyChar) {
    }

    void keyReleased(int keyCode) {
        board.stopMoving();
    }

    


    
    
    void moveAll() {
        ball.moveBall();
        board.moveBoard();
    }
    


    public void createBlocks() {
        blocks = new Block[4];
        blocks[0] = new Block(5, 50);
        blocks[1] = new Block(250, 50);
        blocks[2] = new Block(5, 65);
        blocks[3] = new Block(250, 65);
    }

   public boolean hitDetection(){
        if(ball.getBounds().intersects(board.getBounds())){
            boardCollision();
            return true;
        }else{
            for(Block block : blocks) {
                if (ball.getBounds().intersects(block.getBounds())){
                    blockCollision(block);
                    return true;
                }
            }
        }
        return false;
        }
    
   
   public void boardCollision(){
       ball.setDy(-1);
       
       if(ball.getX() + (ball.ballSize / 2) > board.getX() + (board.boardWidth / 2)){
           ball.setDx(ball.getDx());
       }else{
           ball.setDx(- ball.getDx());
       }
       
       
    }
    
    public void blockCollision(Block block){
        
//        int ballLeft = ball.getX();
//        int ballHeight = (int)ball.getBounds().getHeight();
//        int ballWidth = (int)ball.getBounds().getWidth();
//        int ballTop = ball.getY();
//        
//        Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
//        Point pointLeft = new Point(ballLeft - 1, ballTop);
//        Point pointTop = new Point(ballLeft, ballTop - 1);
//        Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
//        
//        if(block.getBounds().contains(pointBottom)){
//            ball.setDy(-1);
//        }
//        if(block.getBounds().contains(pointTop)){
//            ball.setDy(1);
//        }
//        if(block.getBounds().contains(pointLeft)){
//            ball.setDx(1);
//        }
//        if(block.getBounds().contains(pointRight)){
//            ball.setDx(-1);
//        }
        
        if(ball.getY() >= block.y - (block.blockHeight / 2)){
            ball.setDy(1);
        }
        if(ball.getY() <= block.y + (block.blockHeight / 2)){
            ball.setDy(-1);
        }
        if(ball.getX() < block.x){
            ball.setDx(-1);
        }
        if(ball.getX() > block.x){
            ball.setDx(1);
        }
        
//        int thresholdW = ((int)ball.getBounds().getWidth() + block.blockWidth) / 2;
//        int thresholdH = ((int)ball.getBounds().getHeight() + block.blockHeight) / 2;
//        
//        int diffW = Math.abs(block.x - ball.getX());
//        int diffH = Math.abs(block.y - ball.getY());
//        
//        int sideIndication = Math.abs(diffW - thresholdW) - Math.abs(diffH - thresholdH);
//        
//        if(sideIndication <= 0){
//            ball.setDy(- ball.getDy());
//        }
//        if(sideIndication >= 0){
//            ball.setDx(- ball.getDx());
//        }
        
        block.setDestroyed(true);
    }
    
}
