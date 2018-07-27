import java.util.*;

class NQueens {
	//function which checks whether the queen at given position can be attacked or not
	public static boolean isAttacked (int x, int y, int board[][], int N) {

		//checking in the particular row and column
		for (int i = 0; i < N; i++) {
			//row check
			if ((board[x][i] == 1) && (i != y)) {
				return true;
			}

			//column check
			if ((board[i][y] == 1) && (i != x)) {
				return true;
			}
		}

		//diagonals check
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ( ((i + j) == (x + y)) || ((i - j) == (x - y)) ) {
					if (((i != x) || (j != y)) && (board[i][j] == 1)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean nQueens (int board[][], int level, int N) {
		if (level == N) {
			return true;
		}

		for (int j = 0; j < N; j++) {

			if (isAttacked(level, j, board, N)) {
				continue;
			}

			board[level][j] = 1;

			if(nQueens(board, level+1, N)) {
				return true;
			}

			board[level][j] = 0;
		}

		return false;
	}

	public static void displayBoard (int[][] board, int N) {
		System.out.println("\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);

		int size = s.nextInt();

		int board[][] = new int[size][size];

		if (nQueens(board, 0, size)) {
			System.out.println("Solution found!");
			displayBoard(board, size);
		}
		else {
			System.out.println("No solution.");
		}
	}
}
