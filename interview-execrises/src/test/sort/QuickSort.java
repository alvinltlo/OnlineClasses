package test.sort;

public class QuickSort extends SortBase {
	public static void main(String[] args) {
		int[] unsortArray = generateUnsortedArray();
		displayArray(unsortArray);
		quickSort(unsortArray, 0, unsortArray.length-1);
		displayArray(unsortArray);
	}

	private static int partition(int[] array, int left, int right) {
		int i = left, j = right;
		int tmp;
		int privot = array[left + (right - left) / 2];

		while (i <= j) {
			while (array[i] < privot)
				i++;
			while (array[j] > privot)
				j--;
			if (i <= j) {
				tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	public static void quickSort(int[] array, int left, int right) {
		int pivot = partition(array, left, right);
		if (left < pivot - 1)
			quickSort(array, left, pivot - 1);
		if (pivot < right)
			quickSort(array, pivot, right);
	}
}
