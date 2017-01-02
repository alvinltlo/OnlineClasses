package test.math;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		// find two elements in an array that sum to k

		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -5, -7, -11, 5 };
		int sum = 0;

		System.out.println("Hash O(n) for space and time");
		hash(arrays, sum);

		System.out.println("Sorted Array with loops O(nlogn) for time");
		loop(arrays, sum);

		System.out.println("Sorted Array with binarysearch O (nlogn)");
		binarySearch(arrays, sum);
	}

	public static void hash(int[] a, int sum) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < a.length; i++)
			map.put(sum - a[i], true);

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]) && map.get(a[i])) {
				System.out.println(sum - a[i] + "," + a[i]);
				map.put(a[i], false); // remove duplication
				map.put(sum - a[i], false);
			}
		}
	}

	public static void loop(int[] a, int sum) {
		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			int j = a.length - 1;
			while (i < j) {
				int sum3 = a[i] + a[j];
				if (sum3 < sum) {
					i++;
				} else if (sum3 > sum) {
					j--;
				} else {
					System.out.println(a[i] + "," + a[j]);
					i++;
					j--;
				}
			}
		}
	}

	public static void binarySearch(int[] a, int sum) {
		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			int j = Arrays.binarySearch(a, sum - a[i]);
			if (j > i) // filter duplicates
				System.out.println(a[i] + " " + a[j]);
		}
	}
}