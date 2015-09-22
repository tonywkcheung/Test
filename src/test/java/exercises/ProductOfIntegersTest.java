package exercises;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class ProductOfIntegersTest {

    @Test
    public void calculateProductOfIntegersExample1() {
        int[] input = new int[] {1, 7, 3, 4};
        int[] result = ProductOfIntegers.calculateProductOfIntsExceptAtIndex(input);

        assertEquals("[84, 12, 28, 21]", Arrays.toString(result));
    }

    @Test
    public void calculateProductOfIntegersExample2() {
        int[] input = new int[] {3, 1, 2, 5, 6, 4};
        int[] result = ProductOfIntegers.calculateProductOfIntsExceptAtIndex(input);

        assertEquals("[240, 720, 360, 144, 120, 180]", Arrays.toString(result));
    }

}