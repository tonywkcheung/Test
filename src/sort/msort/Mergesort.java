package sort.msort;


public class Mergesort<T extends Comparable<T>> {

	protected T swapSpace[];

	public void sort(T array[])
	{
		if (array != null && array.length > 1) {
			int maxLength = array.length;
			swapSpace = array.clone();
			mergeSort(array, 0, maxLength - 1);
			swapSpace = null;
		}
	}

	protected void mergeSort(T[] array, int left, int right)
	{
		if (left < right) {
			int mid;

			mid = (left + right) / 2;
			this.mergeSort(array, left, mid);
			this.mergeSort(array, mid + 1, right);
			this.merge(array, left, mid, right);
		}
	}

	protected void merge(T[] array, int left, int middle, int right)
	{
		int firstHalf, secondHalf, count;

		firstHalf = count = left;
		secondHalf = middle + 1;
		
		while ((firstHalf <= middle) && (secondHalf <= right)) {
			
			if (array[secondHalf].compareTo(array[firstHalf]) < 0) {
				swapSpace[count++] = array[secondHalf++];
			}
			else {
				swapSpace[count++] = array[firstHalf++];
			}
		}
		
		if (firstHalf <= middle) {
			while (firstHalf <= middle)
				swapSpace[count++] = array[firstHalf++];
		}
		else {
			while (secondHalf <= right)
				swapSpace[count++] = array[secondHalf++];
		}
		
		for (count = left; count <= right; count++) {
			array[count] = swapSpace[count];
		}
	}
}
