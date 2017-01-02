package test.array;

public class Print2DArraySpiral {

	public static void main(String[] args) {
		int[][] board = new int[4][4];
		board[0][0] = 0;
		board[1][0] = 1;
		board[2][0] = 2;
		board[3][0] = 3;
		board[3][1] = 4;
		board[3][2] = 5;
		board[3][3] = 6;
		board[2][3] = 7;
		board[1][3] = 8;
		board[0][3] = 9;
		board[0][2] = 10;
		board[0][1] = 11;
		board[1][1] = 12;
		board[2][1] = 13;
		board[2][2] = 14;
		board[1][2] = 15;
		print_layer_top_right(board, 0, 0, board.length - 1,
		        board[0].length - 1);
	}

	public static void print_layer_top_right(int a[][], int x1, int y1, int x2,
	        int y2) {
		int i = 0, j = 0;

		// print the row
		for (i = x1; i <= x2; i++) {
			System.out.println(a[i][y1]);
		}

		// print the column
		for (j = y1 + 1; j <= y2; j++) {
			System.out.println(a[x2][j]);
		}

		// see if we have more cells left
		if(x2-x1 > 0 && y2-y1 > 0) {
			// 'recursively' call the function to print the bottom-left layer
			print_layer_bottom_left(a, x1, y1 + 1, x2 - 1, y2);
		}
	}

	public static void print_layer_bottom_left(int a[][], int x1, int y1,
	        int x2, int y2) {
		int i = 0, j = 0;

		// print the row of the matrix in reverse
		for (i = x2; i >= x1; i--) {
			System.out.println(a[i][y2]);
		}

		// print the last column of the matrix in reverse
		for (j = y2 - 1; j >= y1; j--) {
			System.out.println(a[x1][j]);
		}

		if(x2-x1 > 0 && y2-y1 > 0) {
			// 'recursively' call the function to print the top-right layer
			print_layer_top_right(a, x1 + 1, y1, x2, y2 - 1);
		}
	}
}
