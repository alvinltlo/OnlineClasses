package mooc.vandy.java4android.calculator.logic;

/**
 * Created by mkong on 1/1/17.
 */

public abstract class Calculator {
    protected int remainder = 0;

    public abstract int calculate(int one, int two);

    public int getRemainder() { return remainder; }
}
