package test.math;

/**
 * Q10: Write a program that takes an integer and prints out all ways to
 * multiply smaller integers that equal the original number, without repeating
 * sets of factors.
 */
public class PrintAllFactors {

	public static void main(String[] args) {
		PrintFactors(12);
		System.out.println();
		PrintFactors(32);
	}

	public static void PrintFactors(int number) {
		printFactorsHelper("", number, number);
	}

	private static void printFactorsHelper(String currExpression, int dividend,
	        int previousFactor) {
		for (int factor = dividend; factor >= 2; --factor) {
			if (dividend % factor == 0 && factor <= previousFactor) {
				// found 2 factors
				int nextFactor = dividend / factor;

				// try printing only if secondfactor is smaller (i.e. descending
				// order)
				if (nextFactor <= factor) {
					if (nextFactor <= previousFactor) {
						System.out.println(currExpression + factor + " * "
						        + nextFactor);
					}
				}
				printFactorsHelper(currExpression + factor + " * ", nextFactor,
				        factor);
			}
		}
	}
}
