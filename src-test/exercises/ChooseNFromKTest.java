package exercises;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChooseNFromKTest {

    static ChooseNFromK chooseNFromK;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        chooseNFromK = new ChooseNFromK();
    }

    @Test
    public void choose3From7() {
        assertEquals(35, chooseNFromK.calc(7, 3));
    }

    @Test
    public void choose0From4() {
        assertEquals(1, chooseNFromK.calc(4, 0));
    }

    @Test
    public void choose2From4() {
        assertEquals(6, chooseNFromK.calc(4, 2));
    }
}
