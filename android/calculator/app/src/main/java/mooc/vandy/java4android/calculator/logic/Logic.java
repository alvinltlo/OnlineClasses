package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        Calculator c = null;

        switch (operation) {
            case 1:
                c = new Add(argumentOne, argumentTwo);
                break;
            case 2:
                c = new Subtract(argumentOne, argumentTwo);
                break;
            case 3:
                c = new Multiply(argumentOne, argumentTwo);
                break;
            case 4:
                c = new Divide(argumentOne, argumentTwo);
                break;
            default:
                mOut.print("Unknown operation.");

        }

        if (c != null) {
            mOut.print(c.toString());
        }
    }
}
