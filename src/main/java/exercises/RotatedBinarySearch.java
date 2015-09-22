package exercises;

public class RotatedBinarySearch {

    public static boolean find(int[] array, int key) {

        int start = 0;
        int end = array.length-1;

        while (start <= end) {

            int mid = start + ((end-start) / 2);

            int value = array[mid];

            //System.out.println(start + " " + array[start] + ", " + end + " " + array[end] + ", " + mid + " " + value);

            if (value == key) {
                return true;
            }
            else if (array[start] <= array[mid]) {
                if (key > value) {
                    start = mid + 1;
                } else if (key >= array[start]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else if (key < array[mid]) {
                end = mid-1;
            }
            else if (key <= array[end]) {
                start = mid+1;
            }
            else {
                end = mid-1 ;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        //int[] array = {8,9,10,11,12,1,3,4,5,7};
        int[] array = {7,8,9,10,11,12,1,3,4,5};

        boolean result = find(array, 7);

        System.out.println(result);
    }
}
