package test.string;

/**
 * Q5: Convert a number to roman numerals, and back again Roman numerals stem
 * from the numbering system of ancient Rome. They are still used today, often
 * on clock faces or as copyright dates. The numbers 1 through 10 written in
 * roman numerals are as follows: I, II, III, IV, V, VI, VII, VIII, IX, X
 * 
 * http://www.vinaysingh.info/roman/
 *
 */

public class IntegerToRomanNumerals {

	public static void main(String[] arg) {
		System.out.println("12: " + convert(12));
		//System.out.println("999: " + convert(999));
	}

	public static String convert(Integer input) {
		String roman = "";
		int repeat;
		int magnitude[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
		        1 };
		String symbol[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
		        "IX", "V", "IV", "I" };

		for (int x = 0; input > 0; x++) {
			repeat = input / magnitude[x];
			for (int i = 1; i <= repeat; i++) {
				roman = roman + symbol[x];
			}
			input = input % magnitude[x];
		}
		return roman;
	}
}
