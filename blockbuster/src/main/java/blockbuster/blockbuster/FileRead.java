package blockbuster.blockbuster;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileRead {

    File fastestTime;
    Scanner scanner;

    public FileRead() {
        this.fastestTime = new File("fastestTime.txt");
    }

    public double getFastestTime() throws FileNotFoundException, IOException {

        try{
            
            scanner = new Scanner(fastestTime);
            double time = Double.valueOf(scanner.nextLine());
            scanner.close();
            return time;
        }catch (FileNotFoundException e){
            System.out.println("NO HIGHSCORES FOUND");
            return Integer.MAX_VALUE;
            
        }
        
    }

    public void setFastestTime(double time) throws IOException {

        FileWriter writer = new FileWriter(fastestTime);
        fastestTime.createNewFile();
        writer.write(String.valueOf(time));
        writer.close();

    }
    
    public void resetFastestTime() throws IOException{
        FileWriter writer = new FileWriter(fastestTime);
        fastestTime.createNewFile();
        writer.write(String.valueOf(Double.MAX_VALUE));
        writer.close();
    }
}
