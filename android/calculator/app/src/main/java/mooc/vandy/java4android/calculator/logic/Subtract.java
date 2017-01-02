package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract extends Calculator {
    public Subtract(int one, int two) { super(one, two); }

    public int calculate() { return two - one; }
}
