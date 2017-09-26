package kbjx.sudoku;

public class Solution {
	private int[][] sudoku;

	public Solution(int[][] sudoku) {
		this.sudoku = sudoku;
	}

	// check if sudoku filled
	public boolean checkFull() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudoku[row][col] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// check all rows
	public boolean checkRow() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 8; col++) {
				for (int colp = col + 1; colp < 9; colp++) {
					if (Math.abs(sudoku[row][col]) == Math.abs(sudoku[row][colp]))
						return false;
				}
			}
		}
		return true;
	}

	// check all comuns
	public boolean checkColum() {
		for (int col = 0; col < 9; col++) {
			for (int row = 0; row < 8; row++) {
				for (int rowp = row + 1; rowp < 9; rowp++) {
					if (Math.abs(sudoku[row][col]) == Math.abs(sudoku[rowp][col]))
						return false;
				}
			}
		}
		return true;
	}

	// check all squares
	public boolean checkSquare() {
		for (int row = 0; row < 9; row += 3)
			for (int col = 0; col < 9; col += 3)
				for (int pos = 0; pos < 8; pos++)
					for (int pos2 = pos + 1; pos2 < 9; pos2++)
						if (Math.abs(sudoku[row + pos % 3][col + pos / 3]) == Math
								.abs(sudoku[row + pos2 % 3][col + pos2 / 3])) {
							return false;
						}
		return true;
	}

}
