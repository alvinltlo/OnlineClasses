package test.search;

public class BinarySearch {

	public static void main(String[] args) {

		int sorted_array[] = new int[1000];
		for (int i = 0; i < sorted_array.length; i++) {
			sorted_array[i] = i;
		}

		int index = binarySearch(sorted_array, 70);
		System.out.println("binarySearch: " + index);

		index = binarySearchRecursive(sorted_array, 0, sorted_array.length - 1,
		        70);
		System.out.println("rBinarySearch: " + index);
	}

	public static int binarySearch(int[] array, int key) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key < array[mid]) {
				end = mid - 1; // repeat search in bottom half.
			} else if (key > array[mid]) {
				start = mid + 1; // Repeat search in top half.
			} else {
				return mid; // Found it. return position
			}
		}
		return -1; // Failed to find key
	}

	public static int binarySearchRecursive(int[] array, int start, int end,
	        int key) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			if (key < array[mid]) {
				return binarySearchRecursive(array, start, mid - 1, key);

			} else if (key > array[mid]) {
				return binarySearchRecursive(array, mid + 1, end, key);

			} else {
				return mid; // Found it.
			}
		}
		return -1; // Failed to find key
	}

}