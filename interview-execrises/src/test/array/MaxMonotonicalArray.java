package test.array;

/**
 * Write a function to find a max in a monotonically increase and decrease
 * integer array.
 *
 */
public class MaxMonotonicalArray {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 19, 8, 2 };
		System.out.println("Max is: " + findMax(array, 0, array.length - 1));
	}

	public static int findMax(int[] array, int start, int end) {
		if (array.length == 1)
			return array[0];
		if (array.length == 2)
			return Math.max(array[0], array[1]);
		
		int mid = start + (end - start) / 2;
		if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1])
			return array[mid];
		if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1])
			return findMax(array, mid + 1, end);
		else
			return findMax(array, start, mid - 1);
	}
}
