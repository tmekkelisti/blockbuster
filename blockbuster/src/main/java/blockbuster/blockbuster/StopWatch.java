package blockbuster.blockbuster;

public class StopWatch {

    private long start;
    private long stop;
    private double totalTime;
    private boolean counting;
    public boolean lock;
    Logic logic;

    public StopWatch(Logic logic) {
        this.start = 0;
        this.stop = 0;
        this.logic = logic;
        this.counting = false;
        this.lock = false;
    }

    /**
     * aloittaa ajanlaskun jos ei ole lukossa
     */
    
    public void startWatch() {
        if(!lock){
            this.start = System.currentTimeMillis();
            this.counting = true;
        }


    }
    
    /**
     * pysäyttää sekkarin
     */

    public void stopWatch() {
        this.stop = System.currentTimeMillis();
        this.counting = false;

    }

    /**
     * Jos ajanlasku on käynnissä palauttaa sen hetkisen ajan.
     * Jos ei niin palauttaa kokonaisajan
     * @return 
     */
    
    public double getTime() {
        double elapsed;
        if (counting) {
            elapsed = (System.currentTimeMillis() - start) / 1000.0;
        } else {
            elapsed = (stop - start) / 1000.0;
        }
        return elapsed;
    }

    public boolean alreadyCounting() {
        return this.counting;
    }
}
