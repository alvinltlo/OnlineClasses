package test.sort;

import java.util.Random;

public class SortBase {
	public static int[] generateUnsortedArray() {
		Random r = new Random();
		int unsorted_array[] = new int[10];
		for (int i = 0; i < unsorted_array.length; i++) {
			unsorted_array[i] = r.nextInt(101);
		}
		return unsorted_array;
	}

	public static void displayArray(int[] a) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++)
			sb.append(a[i] + ", ");
		sb.append("\n");
		System.out.println(sb);
	}
}
