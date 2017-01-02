package test.array;

/**
 * Suppose that you have an array of both positive and negative integers. Write
 * a function that will find the continuous sequence within the array that has
 * the largest sum of numbers. Return the sum. For example, suppose that you are
 * given the following array: {4, -1, 2, -2, -1, -3}. Then the output of the
 * function should be “5″, because of the fact that the sequence of {4, -1, 2},
 * when 4 + -1 + 2 is calculated it will return 5
 */

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int[] array = { 4, -1, 2, -2, -1, -3 };
	}

	public static int maxSum(int[] array) {
		int currentSum = 0, max = 0;
		for (int i = 0; i < array.length; i++) {
			currentSum += array[i];
			if (max < currentSum)
				max = currentSum;
			else if (currentSum < 0)
				currentSum = 0;
		}
		return max;
	}
}
