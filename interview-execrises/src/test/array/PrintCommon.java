package test.array;

/**
 * Asked by TinTri phone interview Input: a = [1,2,3,4,10,20,30] b =
 * [4,20,30,31]
 * 
 * Output: c = [4, 20, 30]
 * 
 * def printCommon(a,b): """ Input: a and b are sorted array All the below
 * condition are true a.len > b.len b.len > a.len a.len == b.len
 * 
 * Rules: 1. Only one loop construct can be used. 2. No hasmap or contains or in
 * 3. you can not use any inbuilt library function. 4. If you need you can
 * remove elements from arrays as you process them.
 * 
 * output: Print common number from both elements.
 *
 */
public class PrintCommon {
	private static int[] a = new int[] { 1, 2, 3, 4, 10, 20, 30 };
	private static int[] b = new int[] { 4, 20, 30, 31 };

	public static void printCommon(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				System.out.println(a[i]);
				i++;
				j++;
			} else if (a[i] > b[j])
				j++;
			else
				i++;
		}
	}

	public static void main(String[] args) {
		printCommon(a, b);
	}
}
