package test.array;

/**
 * Median of two sorted arrays
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 */
public class FindMedianTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 0, 2, 3, 4 };
		int[] arr2 = { 1, 5, 6, 7, 8 };
		int[] arr3 = { 1, 2, 5 };
		
		int[] arr4 = { 1, 3, 4 };
		int[] arr5 = { 2, 5, 6 };

		System.out.println("Merge 1:");
		merge(arr1, arr2);
		System.out.println("\nMerge 2:");
		merge(arr1, arr3);

		System.out.println("\nMedian: " + findMedianSortedArrays(arr4, arr5));
		System.out.println("\nMedian: " + findMedianSortedArrays(arr1, arr3));
	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A,
			        B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) /2;
		}
	}

	public static int findKth(int A[], int B[], int k, int aStart, int aEnd,
	        int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return Math.min(A[aStart], B[bStart]);

		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	public static void merge(int[] array1, int[] array2) {
		int[] merged = new int[array1.length + array2.length];
		int index = 0, i = 0, j = 0;
		while (index < merged.length && i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				merged[index] = array1[i];
				i++;
				index++;
			} else {
				merged[index] = array2[j];
				j++;
				index++;
			}
		}

		while (i < array1.length) {
			merged[index] = array1[i];
			i++;
			index++;
		}
		while (j < array2.length) {
			merged[index] = array2[j];
			j++;
			index++;
		}

		for (int k : merged) {
			System.out.print(k + ",");
		}
	}
}
