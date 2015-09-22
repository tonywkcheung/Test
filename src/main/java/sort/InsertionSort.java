package sort;

public class InsertionSort<T extends Comparable<T>> {

    public void sort(T[] array) {
        // Check for empty or null array
        if (array == null || array.length == 0) {
            return;
        }

        insertionSort(array);
    }

    // for i = 1 to length(A) - 1
    // x = A[i]
    // j = i
    // while j > 0 and A[j-1] > x
    // A[j] = A[j-1]
    // j = j - 1
    // A[j] = x

    public void insertionSort(T[] array) {

        for (int i=1; i<array.length; i++) {
            int j=i;
            while (j>0 && (array[j].compareTo(array[j-1]) < 0)) {
                swap(array, j, j-1);
                j--;
            }
        }
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
