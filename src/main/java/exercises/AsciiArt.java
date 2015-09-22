package exercises;

import java.util.Scanner;

public class AsciiArt {

    private static final int X = 80;
    private static final int Y = 40;

    char[][] buffer = new char[Y][X];

    public String toAsciiArt(String input) {

        initialize();

        String[] lines = input.split("\n");

        for (String line : lines) {

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(" ");

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char ch = (char) scanner.nextInt();

            buffer[y][x] = ch;
            
            scanner.close();
        }

        return toString();
    }

    private void initialize() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                buffer[i][j] = ' ';
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                sb.append(buffer[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
