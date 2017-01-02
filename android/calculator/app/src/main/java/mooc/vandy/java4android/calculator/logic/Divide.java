package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide implements Calculator {
    private int remainder = 0;

    public int calculate(int one, int two) {
        if (two == 0) { throw new ArithmeticException("Divided by 0"); }

        this.remainder = one % two;
        return one / two;
    }

    public int getRemainder() { return remainder; }
}
