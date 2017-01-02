package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide extends Calculator {
    private int remainder = 0;

    public Divide(int one, int two) { super(one, two); }

    public int calculate() {
        if (two == 0) { throw new ArithmeticException("Divided by 0"); }

        this.remainder = one % two;
        return one / two;
    }

    public String toString() {
        try {
            return String.valueOf(calculate()) + " R: " + remainder;
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
    }
}
