package test.string;

import java.util.HashMap;

public class ContinueCharCount {

	public static void main(String[] args) {
		String input = "aabaaabbaaaac";
		HashMap<Character, Integer> map = count(input);
		for (Character c : map.keySet()) {
			System.out.println(c + ": max count = " + map.get(c));
		}
	}

	public static HashMap<Character, Integer> count(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// handle special case
		if (str.length() == 0)
			return map;
		if (str.length() == 1)
			map.put(str.charAt(0), 1);

		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == (str.charAt(i - 1))) {
				count++;
			} else {
				Integer c = map.get(str.charAt(i - 1));
				if (c == null) {
					map.put(str.charAt(i - 1), count);
				} else {
					if (c < count)
						map.put(str.charAt(i - 1), count);
				}
				count = 1;
			}
		}

		Integer c = map.get(str.charAt(str.length() - 1));
		if (c == null) {
			map.put(str.charAt(str.length() - 1), count);
		} else if (c < count) {
			map.put(str.charAt(str.length() - 1), count);
		}
		return map;
	}
}
