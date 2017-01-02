package test.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * google onsite interview
 */
public class UniqueIndex {

	public static void main(String[] args) {
		set('a', 1);
		set('a', 2);
		set('a', 3);
		print(charToIndex);
		print(indexToChar);
		System.out.println("\na's index is " + getIndex('a')); // expect to be 1
		set('b', 1);
		System.out.println("b's index is " + getIndex('b')); // expect to be 1
		System.out.println("a's index is " + getIndex('a')); // expect to be 2
	}

	static HashMap<Character, ArrayList<Integer>> charToIndex = new HashMap<Character, ArrayList<Integer>>();
	static HashMap<Integer, Character> indexToChar = new HashMap<Integer, Character>();

	public static void print(HashMap map) {
		for (Object o : map.keySet()) {
			if (o instanceof Character) {
				Character c = (Character) o;
				System.out.println(c);
				ArrayList<Integer> list = charToIndex.get(c);
				for (Integer i : list) {
					System.out.print(i + ",");
				}
			}
			if (o instanceof Integer) {
				Integer i = (Integer) o;
				System.out.print("\nIndex " + i + "=" + indexToChar.get(i));
			}
		}
	}

	public static void set(char c, int index) {
		// setup charToIndex
		ArrayList<Integer> list = charToIndex.get(c);
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(index);
			charToIndex.put(c, list);
		} else
			list.add(index);
		indexToChar.put(index, c);
	}

	public static int getIndex(char c) {
		ArrayList<Integer> list = charToIndex.get(c);
		Collections.sort(list);
		for (int i : list) {
			Character temp = indexToChar.get(i);
			if (temp != null) {
				if (c == temp) {
					return i;
				}
			}
		}
		return -1;
	}
}
