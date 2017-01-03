public class Diamond {

	public static void main(String[] args) {
		printDiamond(10);
	}

	public static void printDiamond(int size) {
		int height = (size - 1) * 2 + 3;
		int width = (size * 2) - 2 ; // not including | and < or / or \
		char filler;

		for (int row = 0; row < height; row++) {
			filler = (row % 2 == 0) ? '-' : '=';
			if (row == 0 || row == height - 1) {
				//special handling for first and last line
				System.out.print('+');
				System.out.print(writeChars('-', size * 2));
				System.out.println('+');
			} else {
				System.out.print("|");
				if (row == size) {
					// this is the middle
					System.out.print("<");
					System.out.print(writeChars(filler, width));
					System.out.print(">");
				} else {
					// print top and bottom traingle.
					// We are processing the bottom when size - row < 0.
					boolean isTop = size - row > 0;
					int sideSpace = Math.abs(size - row); 
					System.out.print(writeChars(' ', sideSpace));
					System.out.print(isTop ? "/" : "\\");
					System.out.print(writeChars(filler, width - sideSpace * 2));
					System.out.print(isTop ? "\\" : "/");
					System.out.print(writeChars(' ', sideSpace));
				}

				System.out.println("|");
			}
		}
	}

	public static String writeChars(char c, int length) {
		return new String(new char[length]).replace("\0", String.valueOf(c));
	}
}

