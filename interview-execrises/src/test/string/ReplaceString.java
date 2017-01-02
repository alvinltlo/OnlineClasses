package test.string;

/**
 * LinkedIn Interview Prep
 * 
 * Q1: Implement a function that will take three Strings as arguments and return
 * the first string with all instances of the second string replaced by the
 * third string. Do not use any of the standard regexp functions, obviously.
 * Linear time or better
 *
 */
public class ReplaceString {

	public static void main(String[] args) {
		System.out.println(replace("Thisisabook", "is", "cat"));
	}

	public static String replace(String original, String subString,
	        String newString) {

		StringBuilder result = new StringBuilder();
		char[] char_original = original.toCharArray();
		char[] char_subString = subString.toCharArray();
		int j;

		for (int i = 0; i < original.length() - subString.length(); i++) {
			for (j = 0; j < subString.length(); j++) {
				if (char_original[i + j] != char_subString[j])
					break;
			}
			if (j == subString.length()) {
				// they are substring, skip something
				i = i + char_subString.length - 1;
				result.append(newString);
				continue;
			}
			result.append(char_original[i]);
		}

		for (int i = original.length() - subString.length(); i < original
		        .length(); i++) {
			result.append(char_original[i]);
		}

		return result.toString();
	}
}
