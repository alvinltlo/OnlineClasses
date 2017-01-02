package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply extends Calculator {
    public Multiply(int one, int two) { super(one, two); }

    public int calculate() { return one * two; }
}
