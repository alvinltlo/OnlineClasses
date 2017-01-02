package test.string;
public class Palindrome {
	public static boolean palindrome(String str) {
		int i = 0;
		int j = str.length() - 1;

		char[] str_array = str.toCharArray();
		while (i < j) {
			if (str_array[i] != str_array[j])
				return false;
			else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(palindrome("badab"));
		System.out.println(palindrome("abcdef"));
	}
}
