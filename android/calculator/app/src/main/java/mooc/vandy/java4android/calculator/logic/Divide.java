package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide extends Calculator {
    public int calculate(int one, int two) {
        if (two == 0) { throw new ArithmeticException("Divided by 0"); }

        this.remainder = one % two;
        return one / two;
    }
}
