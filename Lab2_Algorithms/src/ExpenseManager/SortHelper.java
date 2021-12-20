package ExpenseManager;

public class SortHelper {

	private void merge(int[] array, int left, int mid, int right) {
		int length1 = mid - left + 1;
		int length2 = right - mid;

		int[] aLeft = new int[length1];
		int[] aRight = new int[length2];

		for (int i = 0; i < length1; i++)
			aLeft[i] = array[i + left];

		for (int i = 0; i < length2; i++)
			aRight[i] = array[mid + 1 + i];

		int i = 0, j = 0, k = left;
		while (i < length1 && j < length2) {
			if (aLeft[i] > aRight[j]) {
				array[k] = aLeft[i];
				i++;
			} else {
				array[k] = aRight[j];
				j++;
			}
			k++;
		}

		while (i < length1) {
			array[k] = aLeft[i];
			i++;
			k++;
		}
		while (j < length2) {
			array[k] = aRight[j];
			j++;
			k++;
		}
	}

	public void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	public void printArray(int[] array, int size) {
		if (size == 0)
			size = array.length;
		for (int i = 0; i < size; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}
