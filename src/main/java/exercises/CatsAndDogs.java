package exercises;

import java.util.Random;

public class CatsAndDogs {
    int cats = 0;
    int dogs = 0;
    int ratio = 50;

    public void run(int n) {
        Random rand = new Random();
        for (int i=0; i<n; i++) {
            int generatedInt = rand.nextInt(100);
            if (generatedInt >= ratio) {
                cats += 1;
                ratio++;
            }
            else {
                dogs += 1;
                ratio--;
            }
        }
        System.out.println(String.format("Cats[%d], Dogs[%d]", cats, dogs));
    }

    public static void main(String[] args) {
        CatsAndDogs catsAndDogs = new CatsAndDogs();
        catsAndDogs.run(100000);
    }
}
