package test.string;


/**
 * Write a description of Diamond here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diamond {
    public static void printHeaderOrFooter(int size) {
        System.out.print("+");
        System.out.print(new String(new char[size * 2]).replace("\0", "-"));
        System.out.println("+");
    }
        
    public static void printDiamond(int size) {
        printHeaderOrFooter(size);
        
        String filler;
       
        // For column operation.
        int c;
        int c_end;
        int c_oper;
        
        // A special line counter.  It will increment at the top of the diamond and then decrement
        // after that.
        int line2;
        
        for (int line = 1; line <= size * 2 - 1; line++) {
            filler = (line % 2 == 0) ? "-" : "=";
            System.out.print("|");
            
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
                // For the bottom part of the diamond shape, we will decrement the line2 counter
                // so we can reuse the same print line logic but with a reverse effect.
                line2 = (line > size) ? size - (line - size) : line;
                if (c == size - line2 + 1) {
                    // Left side.
                    if (line2 == size) {
                        System.out.print("<");
                    } else {
                        System.out.print("/");
                    }
                } else if (c == size + line2) {
                    // Right side.
                    if (line2 == size) {
                        System.out.print(">");
                    } else {
                        System.out.print("\\");
                    }
                } else if (c > size - line2 + 1 && c < size + line2) {
                    System.out.print(filler);
                } else {
                    System.out.print(" ");
                }
                
                c += c_oper;
                if (c > size * 2 || c < 1) {
                    break;
                }
            }
            System.out.println("|");
        }
        
        printHeaderOrFooter(size);
    }

    public static void printDiamond() {
        printDiamond(4);
    }
    
	public static void main(String[] args) {
		printDiamond(7);
	}
}
