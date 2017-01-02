package test.string;

public class PrintTriangle {
	public static void main(String[] args) {
		printTrangle(7);
	}

	public static void printTrangle(int size) {
		char midLeft = '<';
		char midRight = '>';
		char upperRight = '\\';
		char upperLeft = '/';
		char lowerRight = '/';
		char lowerLeft = '\\';
		char evenLine = '-';
		char oddLine = '=';

		if (size == 1) {
			System.out.println(midLeft + "" + midRight);
		} else {
			int rowNumber, leftSpace, body;
			for (rowNumber = 1; rowNumber <= size; rowNumber++) {

				// print leftspace
				for (leftSpace = size
				        - 1; leftSpace >= rowNumber; leftSpace--) {
					System.out.print(" ");
				}

				// print body
				int bodySize = rowNumber * 2;
				for (body = 1; body <= bodySize; body++) {
					if (bodySize >= 2 && body == 1) {
						if (rowNumber != size)
							System.out.print(upperLeft);
						else
							System.out.print(midLeft);
					} else if (rowNumber % 2 == 0 && body != bodySize) {
						System.out.print(evenLine);
					} else if (rowNumber % 2 != 0 && body != bodySize) {
						System.out.print(oddLine);
					} else {
						if (rowNumber != size)
							System.out.print(upperRight);
						else
							System.out.print(midRight);
					}
				}

				// make new line
				System.out.println("");
			}
		}
	}
}
