package blockbuster.blockbuster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {

    File fastestTime;
    Scanner reader;

    public FileRead() {
        this.fastestTime = new File("/src/fastestTime.txt");
    }

    public double getFastestTime() throws FileNotFoundException, IOException {

        if (!fastestTime.exists()) {
            fastestTime.createNewFile();
        }

        try {
            reader = new Scanner(this.fastestTime);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        }

        return (double) reader.nextLong();
    }

    public void setFastestTime(double time) throws IOException {
        try (FileWriter writer = new FileWriter(this.fastestTime)) {
            String saveTime = String.valueOf(time);
            writer.append(saveTime);
        }
    }
}
