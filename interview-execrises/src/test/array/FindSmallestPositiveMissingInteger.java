package test.array;

/**
 * Find the smallest positive number missing from an unsorted array Input: {2,
 * 3, 7, 6, 8, -1, -10, 15} Output: 1 Input: { 2, 3, -7, 6, 8, 1, -10, 15 }
 * Output: 4 Input: {1, 1, 0, -1, -2} Output: 2
 * 
 * http://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-
 * an-unsorted-array/
 */
public class FindSmallestPositiveMissingInteger {

	public static void main(String[] args) {
		System.out.println("Solution 1");
		int[] array = new int[] { 9, -9, 2, 3, 8, -2 };
		System.out.println(firstMissingPositive1(array));
		array = new int[] { 0, 3, 4, 2, 1, 10 };
		System.out.println(firstMissingPositive1(array));
		array = new int[] { 2, 3, 7, 6, 8, -1, -10, 15 };
		System.out.println(firstMissingPositive1(array));

		System.out.println("\nSolution 2");
		array = new int[] { 9, -9, 2, 3, 8, -2 };
		System.out.println(firstMissingPositive2(array));
		array = new int[] { 6, 3, 4, 2, 1, 10 };
		System.out.println(firstMissingPositive2(array));
		array = new int[] { 2, 3, 7, 6, 8, -1, -10, 15 };
		System.out.println(firstMissingPositive2(array));
	}

	public static int firstMissingPositive1(int[] array) {
		int i = 0;
		while (i < array.length) {
			if (array[i] > 0 && array[i] <= array.length && array[i] != i + 1
			        && array[i] != array[array[i] - 1]) {
				int temp = array[array[i] - 1];
				array[array[i] - 1] = array[i];
				array[i] = temp;
			} else {
				++i;
			}
		}
		i = 0;
		while (i < array.length && array[i] == i + 1)
			i++;
		return i + 1;
	}

	public static int firstMissingPositive2(int[] array) {
		int i = 0;
		while (i < array.length) {
			// ignore when array[i] is negative
			// ignore when array[i] is outside of the array length
			// ignore when array[i] is already in the correct position
			if (array[i] <= 0 || array[i] >= array.length
			        || array[i] == array[array[i]]) {
				i++;
			} else {
				// swap between array[i] and array[array[i]]
				int temp = array[array[i]];
				array[array[i]] = array[i];
				array[i] = temp;
			}
		}

		i = 1;
		while (i < array.length && array[i] == i)
			i++;
		return i;
	}

}
