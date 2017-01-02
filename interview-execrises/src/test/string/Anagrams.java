package test.string;

/**
 * An anagram is a type of word play, the result of rearranging the letters of a
 * word or phrase to produce a new word or phrase, using all the original
 * letters exactly once
 */
public class Anagrams {

	public static void main(String... args) {
		System.out.println(AnagramsSolution1.isAnagram("abcda", "aacdb"));
		System.out.println(AnagramsSolution2.isAnagram("abcdae", "aacdbt"));
	}

}

// Sort and compare
class AnagramsSolution1 {
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		return sort(s).equals(sort(t));
	}
}

// use array to check character count
class AnagramsSolution2 {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] letters = new int[256]; // assumption ascii

		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}

}