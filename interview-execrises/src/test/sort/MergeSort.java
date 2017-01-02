package test.sort;

public class MergeSort extends SortBase {

	public static void main(String[] args) {
		int[] unsortArray = generateUnsortedArray();
		displayArray(unsortArray);
		mergeSort(unsortArray);
		displayArray(unsortArray);
	}

	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	public static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}

	public static void merge(int[] array, int low, int mid, int high) {
		// copy both halves into a helper array
		int[] tmp = new int[array.length];
		for (int i = low; i <= high; i++) {
			tmp[i] = array[i];
		}

		int i = low;
		int j = mid + 1;
		int current = low;

		while (i <= mid && j <= high) {
			if (tmp[i] <= tmp[j]) {
				array[current] = tmp[i];
				i++;
			} else {
				array[current] = tmp[j];
				j++;
			}
			current++;
		}

		// copy the rest of the left side of the array into the target array;
		while (i <= mid) {
			array[current] = tmp[i];
			current++;
			i++;
		}
	}
}
