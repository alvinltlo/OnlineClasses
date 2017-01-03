package test.asciiArt;

public class PrintDiamond {

	public static void main(String[] args) {
		printDiamond(10);
	}

	public static void printDiamond(int size) {
		int height = (size - 1) * 2 + 3;
		int width = (size * 2) - 2 ; // not including | and < or / or \
		String filler;

		for (int row = 0; row < height; row++) {
			filler = (row % 2 == 0) ? "-" : "=";
			if (row == 0 || row == height - 1) {
				//special handling for first and last line
				System.out.print('+');
				for (int i = 0; i < size * 2; i++) {
					System.out.print('-');
				}
				System.out.println('+');
			} else {
				System.out.print("|");
				if (row < size) {
					// upper triangle
					System.out.print(writeSpace(size - row));
					System.out.print("/");
					for (int i = 0; i < width - ((size - row) *2) ; i++) {
					    System.out.print(filler);
				    }
					System.out.print("\\");
					System.out.print(writeSpace(size - row));
				} else if (row == size) {
					// this is the middle
					System.out.print("<");
					for (int i = 0; i < width; i++)
						System.out.print(filler);
					System.out.print(">");
				} else {
					// lower triangle
					System.out.print(writeSpace(row - size));
					System.out.print("\\");
					for (int i = 0; i < width - (row - size) * 2; i++) {
						System.out.print(filler);
					}
					System.out.print("/");
					System.out.print(writeSpace(row - size));
				}

				System.out.println("|");
			}
		}
	}

	public static String writeSpace(int length) {
		return new String(new char[length]).replace("\0", " ");
	}
}

