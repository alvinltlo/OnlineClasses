package test.string;

/**
 * For all the permutations of a string 
 *
 */
public class Permutations {

	public static void main(String[] args) {
		// PermutationsSolution1.permutation("abcd");
		// PermutationsSolution2.permutation(new
		// StringBuffer("abc"),"abc".length());
		PermutationsSolution3
		        .permutation("abcd".toCharArray(), "abcd".length());
	}
}

class PermutationsSolution1 {
	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 1)
			System.out.println(prefix + str);
		else {
			for (int i = 0; i < n; i++) {
				System.out.println(prefix + " : " + str.charAt(i) + " : "
				        + str.substring(0, i) + " : " + str.substring(i + 1));
				permutation(prefix + str.charAt(i),
				        str.substring(0, i) + str.substring(i + 1));
			}
		}
	}
}

class PermutationsSolution2 {
	public static void permutation(StringBuffer str, int index) {
		//System.out.println("str=" + str + " index=" + index);
		if (index == 0)
			System.out.println(str);
		else {
			// recursively solve this by placing all other chars at current
			// first pos
			permutation(str, index - 1);
			int currPos = str.length() - index;
			for (int i = currPos + 1; i < str.length(); i++) {
				// start swapping all other chars with current first char
				swap(str, currPos, i);
				permutation(str, index - 1);
				// restore back my string buffer
				swap(str, i, currPos);
			}
		}
	}

	private static void swap(StringBuffer str, int pos1, int pos2) {
		char t1 = str.charAt(pos1);
		str.setCharAt(pos1, str.charAt(pos2));
		str.setCharAt(pos2, t1);
	}
}

class PermutationsSolution3 {
	public static void permutation(char[] a, int n) {
		System.out.println("a=" + new String(a) + " , n=" + n);
		if (n == 1) {
			System.out.println(a);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n - 1);
			permutation(a, n - 1);
			swap(a, i, n - 1);
			System.out.println("rollback to " + new String(a) + " i=" + i
			        + " n=" + n);
		}
	}

	// swap the characters at indices i and j
	private static void swap(char[] a, int i, int j) {
		char c;
		c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
}
