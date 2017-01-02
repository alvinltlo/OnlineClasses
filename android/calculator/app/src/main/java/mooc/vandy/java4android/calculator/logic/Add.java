package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add extends Calculator {
    public Add(int one, int two) { super(one, two); }

    public int calculate() { return one + two; }
}
