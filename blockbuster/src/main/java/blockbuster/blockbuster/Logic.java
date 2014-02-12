package blockbuster.blockbuster;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 * Pelin logiikka luokka
 */
public class Logic {

    static final int UI_WIDTH = 400;
    static final int UI_HEIGHT = 600;
    
    public Ball ball;
    public Board board;
    public Block[] blocks;
    public UI ui;
    private boolean pause = false;
    public int lives;
    public int blocksLeft;
    public String info;
    


    public Logic() throws InterruptedException {
        init();
    }
    
    public void init() throws InterruptedException{
        ball = new Ball(this);
        board = new Board(this);
        ui = new UI(this);
        startGame();

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
                if(this.pause = !gameOver()){
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
            infoString(" ");
        }else{
            board.stopMoving();
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
    
    public void createBlocks(){
        blocks = new Block[42];
        int z = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                blocks[z] = new Block(j * 60 + 17, i * 15 + 160);
//                blocks[z].getCoordinates();
                z++;
            }
            
        }
        blocksLeft = blocks.length;
        
        
    }
    
    /**
     * Kertoo monta tiiltä on jäljellä.
     * Jos 0 niin voitto.
     * @return 
     */
    
    public int blocksLeft(){
        if(blocksLeft == 0){
            infoString("YOU WIN!");
            setPause(true);
        }
        return blocksLeft;
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
        
//        if(ball.getY() >= block.y - (block.blockHeight / 2)){
//            ball.setDy(1);
//        }
//        if(ball.getY() <= block.y + (block.blockHeight / 2)){
//            ball.setDy(-1);
//        }
        if (ball.getY() >= block.y) {
            ball.setDy(1);
        }
        if (ball.getY() <= block.y) {
            ball.setDy(-1);
        }
        if (ball.getX() < block.x){
            ball.setDx(-1);
        }
        if (ball.getX() > block.x){
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
        blocksLeft--;
        block.setDestroyed(true);
    }
    
    /**
     * Resettaa koko pelin ja aloittaa elämät ja tiilet alusta
     */
    
    public void startGame(){
        setPause(true);
        ball.resetBall();
        board.resetBoard();
        lives = 4;
        createBlocks();
        infoString("press 'SPACEBAR' to launch!");

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
            ball.stopBall();
            board.stopMoving();
            infoString("GAME OVER!");
        }
    }

    /**
     * Info-stringi joka piirretään UI:ssä
     * @param string 
     */
    
    public void infoString(String string){
        this.info = string;
    }
    

    
}
