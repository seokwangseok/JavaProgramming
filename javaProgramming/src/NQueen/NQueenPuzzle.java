package NQueen;

public class NQueenPuzzle {
	private int[][] array;
	private int count;
	
	NQueenPuzzle(int[][] array, int count) {
		this.array = array;
		this.count = count;
	}

	public static void main(String[] args) {
		int n = 4;
		NQueenPuzzle puzzle = new NQueenPuzzle(new int[n][n], n);
		puzzle.rotatePuzzle(0,0);
	}
	
	private void rotatePuzzle(int row, int col) {
		if (row < this.count) {
			for(int j = col; j < this.count; j++) {
				if (this.isValidPuzzlePosition(row, j)) {
					this.array[row][j] = 1;
					this.rotatePuzzle(row+1, 0);
					
					if (j < this.count) {
						this.array[row][j] = 0;
					}
					
				}
			}
		} else {
			for(int i = 0; i < this.count; i++) {
				for(int j = 0; j < this.count; j++) {
					System.out.print(this.array[i][j] + "  ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private boolean isValidPuzzlePosition(int rowIdx, int colIdx) {
		int row = rowIdx;
		int col = colIdx;
		for(int i = 0; i < this.count; i++) {
			// column 검증
			if (this.array[row][i] == 1) {
				return false;
			}
			
			// row 검증
			if (this.array[i][col] == 1) {
				return false;
			}
			
			// 대각선 내림 + 검증
			if ((row+i) < this.count && (col+i) < this.count) {
				if (this.array[row+i][col+i] == 1) {
					return false;
				}
			}
			
			// 대각선 내림 - 검증
			if ((row+i) < this.count && (col-i) >= 0) {
				if (this.array[row+i][col-i] == 1) {
					return false;
				}
			}
			
			// 대각선 올림 + 검증
			if ((row-i) >= 0 && (col+i) < this.count) {
				if (this.array[row-i][col+i] == 1) {
					return false;
				}
			}
			
			// 대각선 올림 - 검증
			if ((row-i) >= 0 && (col-i) >= 0) {
				if (this.array[row-i][col-i] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}


