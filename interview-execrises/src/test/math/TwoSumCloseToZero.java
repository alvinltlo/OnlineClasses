package test.math;

import java.util.Arrays;

/**
 * Find a Pair Whose Sum is Closest to Zero in Array
 */

public class TwoSumCloseToZero {

	public static void main(String[] args) {
		// find two elements in an array that sum to

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -5, -7, -11, 5 };
		closeSum(array);
	}

	public static void closeSum(int[] array) {
		if (array.length < 2)
			System.out.println("Invalid Input");

		Arrays.sort(array);

		int i = 0, r = array.length - 1;
		int min_sum = Integer.MAX_VALUE, sum;
		int min_i = i;
		int min_r = r;
		while (i < r) {
			sum = array[i] + array[r];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				min_i = i;
				min_r = r;
			}
			if (sum < 0)
				i++;
			else
				r--;
		}
		System.out.println("The two elements whose sum is closet to 0 is "
		        + array[min_i] + " and " + array[min_r]);
	}
}
