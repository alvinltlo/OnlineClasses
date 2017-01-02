package test.string;
import java.util.ArrayList;

/**
 * Write a function that will take a page length and a long string of text and
 * return a list of strings, each string representing one page of the original
 * text. Avoid breaking across words and similar things.
 *
 */
public class BreakText {

	public static void main(String[] args) {
		String longString = "This is a cat and that is a dog.";
		System.out.println(longString.charAt(10));
		System.out.println(longString);
		ArrayList<String> list = breakString(10, longString);
		for (String line : list) {
			System.out.println(line);
		}
	}

	public static ArrayList<String> breakString(int pageLength,
	        String longString) {
		ArrayList<String> list = new ArrayList<String>();
		if (longString.length() < pageLength) {
			list.add(longString);
			return list;
		}

		char[] line = longString.toCharArray();
		int j = pageLength - 1;
		for (; j >= 0; j--) {
			if (line[j] == ' ')
				break;
		}
		list.add(new String(longString.substring(0, j)));
		list.addAll(breakString(pageLength, longString.substring(j+1, longString.length())));
		return list;
	}
}
