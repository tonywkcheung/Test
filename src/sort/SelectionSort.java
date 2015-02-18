package sort;

public class SelectionSort<T extends Comparable<T>> {

    public void sort(T[] array) {
        // Check for empty or null array
        if (array == null || array.length == 0) {
            return;
        }

        selectionSort(array);
    }

    public void selectionSort(T[] array) {

        int minIndex;
        int n=array.length;
        for (int i=0; i<n-1; i++) {
            minIndex=i;
            for (int j=i+1; j<n; j++) {

                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(array, i, minIndex);
            }
        }
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
