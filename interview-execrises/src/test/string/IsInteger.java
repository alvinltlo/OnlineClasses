package test.string;

/**
 * Write a function to determine if a string is a number without using any
 * built-in function.
 * 
 * http://stackoverflow.com/questions/237159/whats-the-best-way-to-check-to-see-
 * if-a-string-represents-an-integer-in-java
 */
public class IsInteger {

	public static void main(String[] args) {
		String str1 = "123";
		String str2 = "-1";
		String str3 = "ABC3";

		System.out.println(str1 + " is integer: " + isInteger(str1));
		System.out.println(str2 + " is integer: " + isInteger(str2));
		System.out.println(str3 + " is integer: " + isInteger(str3));
	}

	public static boolean isInteger(String str) {
		if (str == null)
			return false;
		int len = str.length();
		if (len == 0)
			return false;
		int i = 0;
		if (str.charAt(0) == '-') {
			if (len == 1)
				return false;
			i = 1;
		}

		for (; i < len; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}
}
