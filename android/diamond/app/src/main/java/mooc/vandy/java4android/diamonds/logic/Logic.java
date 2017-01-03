package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */

    public void printHeaderOrFooter(int size) {
        mOut.print("+");
        mOut.print(new String(new char[size * 2]).replace("\0", "-"));
        mOut.println("+");
    }

    public void printDiamond(int size) {
        printHeaderOrFooter(size);

        String filler;

        // For column operation.
        int c;
        int c_end;
        int c_oper;

        // A special line counter.  It will increment at the top of the diamond and then decrement
        // after that.  So for a 7 rows diamond, the counting will be: 1,2,3,4,3,2,1
        int line2;

        for (int line = 1; line <= size * 2 - 1; line++) {
            filler = (line % 2 == 0) ? "-" : "=";
            mOut.print("|");

            if (line > size) {
                // Bottom of the Diamond.
                // Reversing the loop count here so we can re-use the right side print logic for
                // the left side.
                c = size * 2;
                c_end = 1;
                c_oper = -1;
            } else {
                // When it's at the top of the Diamond.
                c = 1;
                c_end = size * 2;
                c_oper = 1;
            }

            while (true) {
                // For the bottom part of the diamond, we will decrement the line2 counter so we
                // can reuse the same print line logic but with a reverse effect.
                line2 = (line > size) ? size - (line - size) : line;
                if (c == size - line2 + 1) {
                    // Left side.
                    if (line2 == size) {
                        mOut.print("<");
                    } else {
                        mOut.print("/");
                    }
                } else if (c == size + line2) {
                    // Right side.
                    if (line2 == size) {
                        mOut.print(">");
                    } else {
                        mOut.print("\\");
                    }
                } else if (c > size - line2 + 1 && c < size + line2) {
                    mOut.print(filler);
                } else {
                    mOut.print(" ");
                }

                c += c_oper;
                if (c > size * 2 || c < 1) {
                    break;
                }
            }
            mOut.println("|");
        }

        printHeaderOrFooter(size);
    }

    public void process(int size) {
        printDiamond(size);
    }
}
