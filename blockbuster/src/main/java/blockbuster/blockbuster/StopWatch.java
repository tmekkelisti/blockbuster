package blockbuster.blockbuster;

public class StopWatch {
    private long start;
    private long stop;
    private double totalTime;
    private boolean counting;
    Logic logic;

    public StopWatch(Logic logic) {
        this.start = 0;
        this.logic = logic;
        this.counting = false;
    }
    
    public void startWatch(){
        this.start = System.currentTimeMillis();
        this.counting = true;
    }
    
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - this.start) / 1000.0;
    }
    
    public double totalTime(){
        this.stop = System.currentTimeMillis();
        return (this.stop - this.start) / 1000.0;
    }
    
    
    public boolean alreadyCounting(){
        return this.counting;
    }
}
