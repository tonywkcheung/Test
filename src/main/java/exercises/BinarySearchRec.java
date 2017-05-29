package exercises;

public class BinarySearchRec {

    private int search(int value, int[] array) {
        return search(value, array, 0, array.length-1);
    }

    private int search(int value, int[] array, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);

        if (value == array[mid]) {
            return mid;
        } else if (value < array[mid]) {
            return search(value, array, 0, mid-1);
        } else if (value > array[mid]) {
            return search(value, array, mid+1, end);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 6, 7, 9, 12, 14};

        BinarySearchRec binSearch = new BinarySearchRec();
        int pos = binSearch.search(12, arr);
        System.out.println(pos);
    }

}
