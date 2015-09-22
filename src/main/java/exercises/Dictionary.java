package exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    
    Set<String> dictionary = new HashSet<>();
    
    public void load(String filename){
        String input = readTextFromFile(filename);
        
        String[] words = input.split("\n");

        for (String word : words) {
            dictionary.add(word.trim());
        }
    }
    
    public boolean checkWord(String word){
        return dictionary.contains(word);
    }

    private String readTextFromFile(String filename) {
        FileInputStream fis;
        File file = new File(filename);
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
