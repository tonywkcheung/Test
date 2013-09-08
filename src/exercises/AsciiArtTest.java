package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class AsciiArtTest {

    @Test
    public void printSimpleArt() {
        AsciiArt asciiArt = new AsciiArt();
        String simpleText = "1 0 65\n2 1 66\n1 1 67\n0 1 68";
        String simpleArt = asciiArt.toAsciiArt(simpleText);
        System.out.println(simpleArt);
    }

    @Test
    public void printBunny() {
        AsciiArt asciiArt = new AsciiArt();
        String bunnyText = readTextFromFile("/Users/tonycheung/Documents/workspace/Test/src/exercises/bunny.txt");
        String bunnyArt = asciiArt.toAsciiArt(bunnyText);
        System.out.println(bunnyArt);
    }

    @Test
    public void printGhostbusters() {
        AsciiArt asciiArt = new AsciiArt();
        String gbText = readTextFromFile("/Users/tonycheung/Documents/workspace/Test/src/exercises/ghostbusters.txt");
        String gbArt = asciiArt.toAsciiArt(gbText);
        System.out.println(gbArt);
    }

    public String readTextFromFile(String filename) {
        File file = new File(filename);
        FileInputStream fis;
        byte[] buffer = new byte[(int) file.length()];

        try {
            fis = new FileInputStream(file);
            fis.read(buffer);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(buffer);
    }
}
