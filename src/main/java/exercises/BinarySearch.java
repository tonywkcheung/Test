package exercises;

public class BinarySearch {

    public static boolean find(int[] array, int key) {

        int start = 0;
        int end = array.length-1;

        while (start <= end) {

            int mid = start + ((end-start) / 2);

            int value = array[mid];

            if (value == key) {
                return true;
            }
            else if (key < array[mid]) {
                end = mid-1;
            }
            else  {
                start = mid+1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[] array = {1,3,4,5,7,8,9,10,11,12};

        boolean result = find(array, 7);

        System.out.println(result);
    }
}
