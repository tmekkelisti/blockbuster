package blockbuster.blockbuster;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 *
 * @author Teemu
 */
public class Logic {

    static final int UI_WIDTH = 400;
    static final int UI_HEIGHT = 600;
    
    Ball ball;
    Board board;
    Block[] blocks;
    UI ui;
    boolean pause = false;
    int lives;


    public Logic() throws InterruptedException {
        init();
    }
    
    public void init() throws InterruptedException{
        ball = new Ball(this);
        board = new Board(this);
        ui = new UI(this);
        startGame();
//        createBlocks();
//        lives = 3;
    }
    
    /**
     * Valvoo näppäimiä
     * @param keyCode 
     */
    
    void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                board.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                board.moveRight();
                break;
            case KeyEvent.VK_SPACE:
                if(this.pause){
                    setPause(false);
                }else{
                    setPause(true);
                }
                break;
            case KeyEvent.VK_ENTER:
                startGame();
                break;
        }
    }

    void keyTyped(char keyChar) {
    }

    void keyReleased(int keyCode) {
        board.stopMoving();
    }

    


    /**
     * liikuttaa palloa ja lautaa, jos pause = false
     */
    
    public void moveAll() {
        if(this.pause == false){
            ball.moveBall();
            board.moveBoard();
        }

    }
    
    /**
     * Tällä voidaan pysäyttää pallon ja laudan liikkuminen
     * @param set 
     */

    public void setPause(boolean set){
        this.pause = set;
    }


    /**
     * luo tiilet for-loopeilla
     */
    
    public void createBlocks() {
        blocks = new Block[4];
        blocks[0] = new Block(5, 50);
        blocks[1] = new Block(250, 50);
        blocks[2] = new Block(5, 65);
        blocks[3] = new Block(250, 65);
    }
    
    
    

    /**
     * tarkistaa törmääkö pallo ensin lautaan ja sitten tiileihin.
     * ajaa sen jälkeen collision metodit riippuen kumpaan osuu.
     * Tiiliin osuessa metodin mukana lähetetään itse tiili parametrinä
     * @return 
     */
    
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
    
   /**
    * Laudan törmäyksen logiikka.
    * Pallon osuessa vasempaan reunaan kimpoaa vasemmalle ja vice versa
    */
   
   
   public void boardCollision(){
       
       int boardCenter = board.getX() + (board.boardWidth / 2);
       int ballCenter = ball.getX() + (ball.ballSize / 2);
       
       ball.setDy(-1);
       
       if(ballCenter > boardCenter){
           ball.setDx(1);
       }else{
           ball.setDx(-1);
       }
       
       
    }
   
   /**
    * Tiilen törmäyksen logiikka.
    * 
    * @param block 
    */
    
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
    
    /**
     * Resettaa koko pelin ja aloittaa elämät ja tiilet alusta
     */
    
    public void startGame(){
        setPause(true);
        ball.resetBall();
        board.resetBoard();
        lives = 3;
        createBlocks();
    }
    
    /**
     * Tarkastaa onko pallo pohjassa.
     * Jos on niin resettaa pallon ja laudan sekä poistaa elämän
     * @return 
     */
    
    public boolean gameOver(){
        if(ball.getY() + ball.ballSize == ui.getHeight()){
            setPause(true);
            ball.resetBall();
            board.resetBoard();
            checkLives();
            return true;
        }
        return false;
    }
    
    /**
     * Vähentää elämiä ja jos alle nolla aloittaa uuden pelin
     */
    
    public void checkLives(){
        if(lives>0){
            lives--;
        }else{
            startGame();
        }
    }

    
}
