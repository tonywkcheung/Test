package exercises;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
	
	char[] board = new char[9];
	List<GameLine> lines = new ArrayList<GameLine>();
	
	public TicTacToe(char[] board) {
		
		initGameLines();
		
		for (int i=0; i < board.length; i++) {
			this.board[i] = board[i];
		}
	}
		
	private void initGameLines() {
		lines.add(new GameLine("row1", board, 0, 1, 2));
		lines.add(new GameLine("row2", board, 3, 4, 5));
		lines.add(new GameLine("row3", board, 6, 7, 8));
		lines.add(new GameLine("col1", board, 0, 3, 6));
		lines.add(new GameLine("col2", board, 1, 4, 7));
		lines.add(new GameLine("col3", board, 2, 5, 8));
		lines.add(new GameLine("diag1", board, 0, 4, 8));
		lines.add(new GameLine("diag2", board, 2, 4, 6));		
	}
	
	public String result() {
		for (GameLine line : lines) {
			if (line.won()) {
				return "Won by " + line.winningPlayer() + " on " + line.id();
			}
		}
		return "No Winner";		
	}

	class GameLine {
		private String id;
		private char[] board;
		private int x;
		private int y;
		private int z;

		public GameLine (String id, char[] board, int x, int y, int z) {
			this.id = id;
			this.board = board;
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public boolean won() {
			if ((board[x] == 'x' || board[x] == 'o') && board[x] == (board[y]) && board[x] == (board[z])) {
				return true;
			}
			return false;
		}
		
		public char winningPlayer() {
			if (won()) {
				return board[x];
			}
			return ' ';
		}

		public String id() {
			return id;
		}
	}
}
