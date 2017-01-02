package test.array;

/**
 * given a sorted array that has been rotated, find a number in that array
 * {6,7,1,2,3,4,5}
 */
public class FindIntFromRotatedArray {

	public static void main(String[] args) {
		int[] array = new int[] { 6, 7, 8, 1, 2, 3, 4, 5 };
		System.out.println("Index for value 4 is: " + searchKey(array, 4));
		System.out.println("Index for value 4 is: "
		        + searchKey(array, 4, 0, array.length - 1));
		System.out.println("Index for value 10 is: " + searchKey(array, 10));
		System.out.println("Index for value 10 is: "
		        + searchKey(array, 10, 0, array.length - 1));
		System.out.println("Pivot is : " + findPivot(array));
	}

	public static int searchKey(int[] array, int key) {
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == key)
				return mid;

			// the first half is sorted
			if (array[start] <= array[mid]) {
				// key is in the first half
				if (array[start] <= key && key < array[mid])
					end = mid - 1;
				else
					// key is in the second half
					start = mid + 1;
			}
			// the second half is sorted
			else {
				// key is in the second half
				if (array[mid] < key && key <= array[end])
					start = mid + 1;
				else
					// key is in the first half
					end = mid - 1;
			}
		}
		return -1;
	}

	// recursive
	public static int searchKey(int[] array, int key, int start, int end) {
		int mid = start + (end - start) / 2;
		if (start > end)
			return -1;

		if (array[mid] == key)
			return mid;

		// the first half is sorted
		if (array[start] <= array[mid]) {
			// key is in the first half
			if (array[start] <= key && key < array[mid])
				return searchKey(array, key, start, mid - 1);
			else
				// key is in the second half
				return searchKey(array, key, mid + 1, end);
		}
		// the second half is sorted
		else {
			// key is in the second half
			if (array[mid] < key && key <= array[end])
				return searchKey(array, key, mid + 1, end);
			else
				// key is in the first half
				return searchKey(array, key, start, mid - 1);
		}
	}

	public static int findPivot(int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (array[mid] > array[end])
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}
}
