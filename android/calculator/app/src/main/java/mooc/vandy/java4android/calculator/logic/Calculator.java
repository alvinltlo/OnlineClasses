package mooc.vandy.java4android.calculator.logic;

/**
 * Created by mkong on 1/2/17.
 */

public abstract class Calculator {
    protected int one;
    protected int two;

    public Calculator(int one, int two) {
        this.one = one;
        this.two = two;
    }

    public String toString() {
        return String.valueOf(calculate());
    }

    public abstract int calculate();
}
