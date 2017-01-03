package test.asciiArt;

/****
print this
   * 
  * *
 * * *
* * * * 
 */

public class PrintTriangle {

	public static void main(String[] args) {
		printTriangle(5);
	}

	public static void printTriangle(int height) {
		for (int row = 1; row <= height; row++) {
			for (int space = height; space > row; space--) {
				System.out.print(' ');
			}
			for (int star = 1; star <= row; star++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}
}
