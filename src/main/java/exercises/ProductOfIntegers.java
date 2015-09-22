package exercises;

public class ProductOfIntegers {

    public static int[] calculateProductOfIntsExceptAtIndex(int[] inArray) {

        int[] outArray = new int[inArray.length];

        int product = 1;

        for (int i=0; i<inArray.length-1; i++) {

            product = product * inArray[i];
            outArray[i+1] = product;
        }

        product = 1;

        for (int j=inArray.length-1; j>0; j--) {

            product = product * inArray[j];

            outArray[j-1] = outArray[j-1] * product;
        }

        outArray[0] = product;

        return outArray;
    }

}
