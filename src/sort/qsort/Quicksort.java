package sort.qsort;

public class Quicksort<T extends Comparable<T>> {

	public void sort(T[] array) {
		// Check for empty or null array
		if (array == null || array.length == 0) {
			return;
		}

		quicksort(array, 0, array.length - 1);
	}

	public void quicksort(T[] array, int left, int right) {
		// If the list has 2 or more items
		if (left < right) {

			int pivot = left + (right - left) / 2;

			// Get lists of bigger and smaller items and final position of pivot
			int newPivot = partition(array, left, right, pivot);

			// Recursively sort elements smaller than the pivot
			quicksort(array, left, newPivot - 1);

			// Recursively sort elements at least as big as the pivot
			quicksort(array, newPivot + 1, right);
		}
	}

	// left is the index of the leftmost element of the array
	// right is the index of the rightmost element of the array (inclusive)
	// number of elements in array = right-left+1
	private int partition(T[] array, int left, int right, int pivot) {

		T pivotValue = array[pivot];

		swap(array, pivot, right); // Move pivot to end

		int storeIndex = left;

		for (int i = left; i < right; i++) { // left ² i < right
			if (array[i].compareTo(pivotValue) < 0) {
				swap(array, i, storeIndex);
				storeIndex++;
			}
		}

		swap(array, storeIndex, right); // Move pivot to final place

		return storeIndex;
	}

	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
