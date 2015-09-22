package exercises;

import static org.junit.Assert.*;

import org.junit.Test;

public class EightQueensTest {

    @Test
    public void test() {
        EightQueens eigthQueens = new EightQueens();
        
        eigthQueens.run();
        
        assertTrue(eigthQueens.isFinished);
    }

}
