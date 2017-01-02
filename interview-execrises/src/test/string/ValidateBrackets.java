package test.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * Google onsite
 */
public class ValidateBrackets {

	public static void main(String[] args) {

		String exp1 = "{[]()}";
		String exp2 = "(1+2)*3";
		String exp3 = "[(])";
		System.out.println(exp1 + " is valid: " + validate(exp1));
		System.out.println(exp2 + " is valid: " + validate(exp2));
		System.out.println(exp3 + " is valid: " + validate(exp3));
	}

	public static boolean validate(String str) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put(')', '(');
		map.put('}', '{');

		Stack<Character> stack = new Stack<Character>();
		char[] array = str.toCharArray();
		for (char c : array) {
			if (c == '[' || c == '{' || c == '(')
				stack.push(c);
			else {
				Character newOpening = map.get(c);
				if (newOpening != null) {
					Character opening = stack.pop();
					if (newOpening != opening)
						return false;
				}
			}
		}
		return true;
	}
}
