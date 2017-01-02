package test.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two words as Strings, determine if they are isomorphic. Two words are
 * called isomorphic if the letters in one word can be remapped to get the
 * second word. Remapping a letter means replacing all occurrences of it with
 * another letter while the ordering of the letters remains unchanged. No two
 * letters may map to the same letter, but a letter may map to itself.
 *
 * Example: given "foo", "app"; returns true we can map 'f' -> 'a' and 'o' ->
 * 'p'
 *
 * given "foo", "boa"; returns false we can map 'f' -> 'b', 'o' -> 'o', we can't
 * map 'o' -> 'a'
 *
 * given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
 *
 * given "turtle", "tletur"; returns true we can map 't' -> 't', 'u' -> 'l', 'r'
 * -> 'e', 'l' -> 'u', 'e' ->'r'
 *
 * given "ab", "ca"; returns true we can map 'a' -> 'c', 'b' -> 'a'
 */
public class Isomorphic {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("foo","bar"));
		System.out.println(isIsomorphic("foo","haa"));
	}

	public static boolean isIsomorphic(String firstWord, String secondWord) {
		if (firstWord == null || secondWord == null)
			return false;
		else if (firstWord.length() != secondWord.length())
			return false;
		else if (firstWord.equals(secondWord))
			return false;
		else {
			Map<Character, Character> mapping = new HashMap<Character, Character>();
			for (int i = 0; i < firstWord.length(); i++) {
				Character t = mapping.get(firstWord.charAt(i));
				if (t != null && t != secondWord.charAt(i)) {
					return false;
				} else {
					mapping.put(firstWord.charAt(i), secondWord.charAt(i));
				}
			}
			return true;
		}
	}
}
