package blockbuster.blockbuster;

import blockbuster.UI.UI;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Pelin logiikka luokka
 */
public class Logic {

    static final int UI_WIDTH = 400;
    static final int UI_HEIGHT = 600;
    static final int LIVES_AT_START = 4;

    public Ball ball;
    public Board board;
    public Block[] blocks;
    public UI ui;
    private boolean pause = false;
    public int lives;
    public int blocksLeft;
    public String info;
    public StopWatch stopWatch;
    public boolean gameFinished = false;
//    public double totalTime = 0;
//    public FileRead fileRead;
//    public double fastestTime;
//    public String timeString = "0";

    public Logic() throws InterruptedException, FileNotFoundException {
        init();
    }

    public void init() throws InterruptedException, FileNotFoundException {
        ball = new Ball(this);
        board = new Board(this);
        ui = new UI(this);
        stopWatch = new StopWatch(this);
//        fileRead = new FileRead();
//        fastestTime = fileRead.getFastestTime();
        startGame();

    }

    /**
     * Valvoo näppäimiä ja triggeroi sekkaria
     *
     * @param keyCode
     */
    public void keyPressed(int keyCode) throws IOException {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                board.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                board.moveRight();
                break;
            case KeyEvent.VK_SPACE:
                if (this.pause != gameOver()) {
                    setPause(false);
                    if (!stopWatch.alreadyCounting()) {
                        stopWatch.startWatch();
                    }
                } else {
                    setPause(true);
                }
                break;
            case KeyEvent.VK_ENTER:
                startGame();
                stopWatch.lock = false;
                break;

            case KeyEvent.VK_ESCAPE:
                blocksLeft = 0;
                break;

            case KeyEvent.VK_1:
                playerWins();
        }
    }

    public void keyTyped(char keyChar) {
    }

    public void keyReleased(int keyCode) {
        board.stopMoving();
    }

    /**
     * liikuttaa palloa ja lautaa, jos pause = false
     */
    public void moveAll() throws IOException {
        if (this.pause == false) {
            ball.moveBall();
            board.moveBoard();
            infoString(" ");
        } else {
//            board.stopMoving();
        }

    }

    /**
     * Tällä voidaan pysäyttää pallon ja laudan liikkuminen
     *
     * @param set
     */
    public void setPause(boolean set) {
        this.pause = set;
    }

    public boolean isPause() {
        return this.pause;
    }

    /**
     * luo tiilet for-loopeilla
     */
    public void createBlocks() {
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
     *
     * @return
     */
    public int blocksLeft() throws IOException {
        return blocksLeft;
    }

    public void playerWins() throws IOException {

        stopWatch.stopWatch();
        infoString("YOU WIN!");
        ball.stopBall();
        board.stopMoving();
        stopWatch.lock = true;
    }

    /**
     * tarkistaa törmääkö pallo ensin lautaan ja sitten tiileihin. ajaa sen
     * jälkeen collision metodit riippuen kumpaan osuu. Tiiliin osuessa metodin
     * mukana lähetetään itse tiili parametrinä
     *
     * @return
     */
    public boolean hitDetection() throws IOException {
        if (ball.getBounds().intersects(board.getBounds())) {
            boardCollision();
            return true;
        } else {
            for (Block block : blocks) {
                if (ball.getBounds().intersects(block.getBounds())) {
                    blockCollision(block);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Laudan törmäyksen logiikka. Pallon osuessa vasempaan reunaan kimpoaa
     * vasemmalle ja vice versa
     */
    public void boardCollision() {

        int boardCenter = board.getX() + (board.boardWidth / 2);
        int ballCenter = ball.getX() + (ball.ballSize / 2);

        ball.setDy(-1);

        if (ballCenter > boardCenter) {
            ball.setDx(1);
        } else {
            ball.setDx(-1);
        }
    }

    /**
     * Tiilen törmäyksen logiikka. Pitää myös huolen voittamisesta.
     *
     * @param block
     */
    public void blockCollision(Block block) throws IOException {

        if (ball.getY() >= block.y) {
            ball.setDy(1);
        }
        if (ball.getY() <= block.y) {
            ball.setDy(-1);
        }
        if (ball.getX() < block.x) {
            ball.setDx(-1);
        }
        if (ball.getX() > block.x) {
            ball.setDx(1);
        }

        blocksLeft--;
        if (blocksLeft == 0) {
            playerWins();
        }
        block.setDestroyed(true);
    }

    /**
     * Resettaa koko pelin ja aloittaa elämät ja tiilet alusta
     *
     * @return
     */
    public boolean startGame() {
        setPause(true);
        ball.resetBall();
        board.resetBoard();
        lives = LIVES_AT_START;
        createBlocks();
        infoString("press 'SPACEBAR' to launch!");
        stopWatch.startWatch();
        return true;

    }

    /**
     * Tarkastaa onko pallo pohjassa. Jos on niin resettaa pallon ja laudan sekä
     * poistaa elämän
     *
     * @return
     */
    public boolean gameOver() throws IOException {

        if (ball.getY() + ball.ballSize == ui.getHeight()) {
            setPause(true);
            ball.resetBall();
            board.resetBoard();
            checkRemainingLives();

            return true;
        }
        return false;
    }

    /**
     * Vähentää elämiä ja jos alle nolla aloittaa uuden pelin
     *
     * @return
     */
    public void checkRemainingLives() throws IOException {
        if (lives > 0) {
            lives--;
        } else {
            ball.stopBall();
            board.stopMoving();
            infoString("GAME OVER!");
            stopWatch.stopWatch();
            stopWatch.lock = true;
        }
    }

    /**
     * Info-stringi joka piirretään UI:ssä
     *
     * @param string
     */
    public void infoString(String string) {
        this.info = string;
    }

    public String getInfo() {
        return info;
    }

    /**
     * tallentaa yhden pelin kokonaisajan paikalliseen muuttujaan
     */
//    public void checkTotalTime() throws IOException{
//        this.totalTime = stopWatch.totalTime();
//        if(this.totalTime < this.fastestTime){
//            fileRead.setFastestTime(totalTime);
//            
//        }
//    }
    /**
     * palauttaa ajan tai kokonaisajan UI:lle
     *
     * @return
     */
    public String timeString() {
        return String.valueOf(stopWatch.getTime());
    }
}
