package test.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Return the sum of all integers from a random String. Continuous Integers must
 * be considered as one number. If the input String does not have any Integers,
 * return 0. You may ignore decimals, float, and other non-integer numbers
 * 
 * @param str
 *            : Input String
 *
 *            Given the following inputs, we expect the corresponding output:
 *            "1a2b3c" => 6 (1+2+3) "123ab!45c" => 168 (123+45) "abcdef" => 0
 *            (no Integers in String) "0123.4" => 127 (0123+4)
 *            "dFD$#23+++12@#T1234;/.,10" => 1279 (23+12+1234+10)
 */
public class SumOfRandomString {

	public static void main(String[] arg) {
		System.out.println("Solution 1");
		System.out.println(SumOfNumbers1("1a2b3c"));
		System.out.println(SumOfNumbers1("123ab!45c"));
		System.out.println(SumOfNumbers1("abcdef"));
		System.out.println(SumOfNumbers1("0123.4"));
		System.out.println(SumOfNumbers1("dFD$#23+++12@#T1234;/.,10"));

		System.out.println("Solution 2");
		System.out.println(SumOfNumbers2("1a2b3c"));
		System.out.println(SumOfNumbers2("123ab!45c"));
		System.out.println(SumOfNumbers2("abcdef"));
		System.out.println(SumOfNumbers2("0123.4"));
		System.out.println(SumOfNumbers2("dFD$#23+++12@#T1234;/.,10"));

		System.out.println("Solution 3");
		System.out.println(SumOfNumbers3("1a2b3c"));
		System.out.println(SumOfNumbers3("123ab!45c"));
		System.out.println(SumOfNumbers3("abcdef"));
		System.out.println(SumOfNumbers3("0123.4"));
		System.out.println(SumOfNumbers3("dFD$#23+++12@#T1234;/.,10"));

		System.out.println("Solution 4");
		System.out.println(SumOfNumbers4("a-54b3e-2-a1"));
		System.out.println(SumOfNumbers4("-5-1"));
		System.out.println(SumOfNumbers4("--1"));

	}

	public static int SumOfNumbers1(String str) {
		int sum = 0;
		int cur = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				cur = cur * 10 + Character.getNumericValue(str.charAt(i));
			} else {
				sum = sum + cur;
				cur = 0;
			}
		}
		return sum = sum + cur;
	}

	public static int SumOfNumbers2(String str) {
		int sum = 0;
		String[] array = str.split("\\D+");
		for (String tmp : array) {
			if (!tmp.equals(""))
				sum += Integer.parseInt(tmp);
		}
		return sum;
	}

	public static int SumOfNumbers3(String str) {
		Matcher m = Pattern.compile("\\d+").matcher(str);
		int sum = 0;
		while (m.find()) {
			sum += Integer.parseInt(m.group());
		}
		return sum;
	}

	/**
	 * In this case, negative value is possible
	 * http://stackoverflow.com/questions
	 * /28223991/write-java-program-to-sum-of-all-integers-from-a-random-string
	 * 
	 * @param str
	 * @return
	 */
	public static int SumOfNumbers4(String str) {
		int sum = 0;
		int currentSum = 0;
		boolean negative = false;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				currentSum = currentSum * 10
				        + Character.getNumericValue(str.charAt(i));
			} else if (str.charAt(i) == '-') {
//				if (currentSum != 0) {
//					sum = sum + currentSum;
//					currentSum = 0;
//				}
			} else {
				if (negative)
					currentSum = currentSum * -1;
				sum = sum + currentSum;
				currentSum = 0;
				negative = false;
			}
		}
		if (negative)
			currentSum = currentSum * -1;
		return sum = sum + currentSum;
	}
}
