package test.string;

import java.util.HashMap;

/**
 * Given a set T of characters and a string S, find the minimum window in S
 * which will contain all the characters in T in complexity O(n). eg, S =
 * “ADOBECODEBANC” T = “ABC”
 * 
 * Minimum window is “BANC”.
 * http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 */
public class MinWindow {

	public static void main(String[] args) {
		String s = "acbbaca";
		String t1 = "aba";
		String t2 = "XYZZ";

		System.out.println(minWindowHashMap(s, t1));
		System.out.println(minWindowHashMap(s, t2));
	}

	public static String minWindow(String str, String target) {
		int sLen = str.length();
		int tLen = target.length();
		int[] needToFind = new int[256];
		for (int i = 0; i < tLen; i++)
			needToFind[target.charAt(i)]++;

		int[] hasFound = new int[256];
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;

		int minWindowBegin = 0, minWindowEnd = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[str.charAt(end)] == 0)
				continue;
			hasFound[str.charAt(end)]++;
			if (hasFound[str.charAt(end)] <= needToFind[str.charAt(end)])
				count++;
			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind[str.charAt(begin)] == 0
				        || hasFound[str.charAt(begin)] > needToFind[str
				                .charAt(begin)]) {
					if (hasFound[str.charAt(begin)] > needToFind[str
					        .charAt(begin)])
						hasFound[str.charAt(begin)]--;
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				}
			}
		}
		if (count == tLen)
			return str.substring(minWindowBegin, minWindowEnd + 1);
		else
			return null;
	}

	public static String minWindowHashMap(String str, String target) {
		int sLen = str.length();
		int tLen = target.length();
		HashMap<Character, Integer> needToFind = new HashMap<Character, Integer>();
		for (int i = 0; i < tLen; i++) {
			needToFind = incrementKeyBy(needToFind, target.charAt(i), 1);
		}

		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;

		int minWindowBegin = 0, minWindowEnd = 0;
		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind.get(str.charAt(end)) == null)
				continue;
			incrementKeyBy(hasFound, str.charAt(end), 1);
			if (hasFound.get(str.charAt(end)) <= needToFind
			        .get(str.charAt(end)))
				count++;
			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind.get(str.charAt(begin)) == null
				        || hasFound.get(str.charAt(begin)) > needToFind.get(str
				                .charAt(begin))) {
					if (hasFound.get(str.charAt(begin)) != null
					        && needToFind.get(str.charAt(begin)) != null
					        && hasFound.get(str.charAt(begin)) > needToFind
					                .get(str.charAt(begin)))
						incrementKeyBy(hasFound, str.charAt(begin), -1);
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				}
			}
		}
		if (count == tLen)
			return str.substring(minWindowBegin, minWindowEnd + 1);
		else
			return null;
	}

	private static HashMap<Character, Integer> incrementKeyBy(
	        HashMap<Character, Integer> map, Character key, int delta) {
		Integer _count = map.get(key);
		if (_count == null)
			map.put(key, 1);
		else
			map.put(key, _count + delta);
		return map;
	}
}
