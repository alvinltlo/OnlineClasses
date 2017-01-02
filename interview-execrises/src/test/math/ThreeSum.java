package test.math;

import java.util.Arrays;

public class ThreeSum {
	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -5, -7, -11, 5};
		int sum = 0;
		threeSum(arrays, sum);
	}

	public static void threeSum(int[] num, int sum) {
	    Arrays.sort(num);

	    for (int i = 0; i < num.length; i++) {
	        int j = i + 1;
	        int k = num.length - 1;
	        while (j < k) {
	            int sum3 = num[i] + num[j] + num[k];
	            if (sum3 < sum) {
	                j++;
	            } else if (sum3 > sum) {
	                k--;
	            } else {
	                System.out.println(num[i] +","+ num[j] +","+ num[k]);
	                j++;
	                k--;
	            }
	        }
	    }
	}
}
