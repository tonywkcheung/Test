package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sudoku {
	
	private int[] board = new int[81];
	private List<GameLine> lines = new ArrayList<GameLine>();
	private Map<String, GameLine> lineMap = new HashMap<String, GameLine>();
	
	public Sudoku() {
		
		initGameLines();
		
		for (int i=0; i < board.length; i++) {
			this.board[i] = 0;
		}
	}
		
	private void initGameLines() {
		
		lines.add(new GameLine("row0", board,  0,  1,  2,  3,  4,  5,  6, 7,  8));
		lines.add(new GameLine("row1", board,  9, 10, 11, 12, 13, 14, 15, 16, 17));
		lines.add(new GameLine("row2", board, 18, 19, 20, 21, 22, 23, 24, 25, 26));
		lines.add(new GameLine("row3", board, 27, 28, 29, 30, 31, 32, 33, 34, 35));
		lines.add(new GameLine("row4", board, 36, 37, 38, 39, 40, 41, 42, 43, 44));
		lines.add(new GameLine("row5", board, 45, 46, 47, 48, 49, 50, 51, 52, 53));
		lines.add(new GameLine("row6", board, 54, 55, 56, 57, 58, 59, 60, 61, 62));
		lines.add(new GameLine("row7", board, 63, 64, 65, 66, 67, 68, 69, 70, 71));
		lines.add(new GameLine("row8", board, 72, 73, 74, 75, 76, 77, 78, 79, 80));

		lines.add(new GameLine("col0", board, 0,  9, 18, 27, 36, 45, 54, 63, 72));
		lines.add(new GameLine("col1", board, 1, 10, 19, 28, 37, 46, 55, 64, 73));
		lines.add(new GameLine("col2", board, 2, 11, 20, 29, 38, 47, 56, 65, 74));
		lines.add(new GameLine("col3", board, 3, 12, 21, 30, 39, 48, 57, 66, 75));
		lines.add(new GameLine("col4", board, 4, 13, 22, 31, 40, 49, 58, 67, 76));
		lines.add(new GameLine("col5", board, 5, 14, 23, 32, 41, 50, 59, 68, 77));
		lines.add(new GameLine("col6", board, 6, 15, 24, 33, 42, 51, 60, 69, 78));
		lines.add(new GameLine("col7", board, 7, 16, 25, 34, 43, 52, 61, 70, 79));
		lines.add(new GameLine("col8", board, 8, 17, 26, 35, 44, 53, 62, 71, 80));

		lines.add(new GameLine("grid0", board,  0,  1,  2,  9, 10, 11, 18, 19, 20));
		lines.add(new GameLine("grid1", board,  3,  4,  5, 12, 13, 14, 21, 22, 23));
		lines.add(new GameLine("grid2", board,  6,  7,  8, 15, 16, 17, 24, 25, 26));
		lines.add(new GameLine("grid3", board, 27, 28, 29, 36, 37, 38, 45, 46, 47));
		lines.add(new GameLine("grid4", board, 30, 31, 32, 39, 40, 41, 48, 49, 50));
		lines.add(new GameLine("grid5", board, 33, 34, 35, 42, 43, 44, 51, 52, 53));
		lines.add(new GameLine("grid6", board, 54, 55, 56, 63, 64, 65, 72, 73, 74));
		lines.add(new GameLine("grid7", board, 57, 58, 59, 66, 67, 68, 75, 76, 77));
		lines.add(new GameLine("grid8", board, 60, 61, 62, 69, 70, 71, 78, 79, 80));
		
		for (GameLine line : lines) {
			lineMap.put(line.id(), line);
		}
	}

	public GameLine getLine(String id) {
		return lineMap.get(id);
	}

	public void initValues(String id, int[] values) {
		getLine(id).init(values);
	}
	
	public void updateStatistics() {
		for (GameLine line : lines) {
			line.updateStatistics();
		}
	}

	public boolean solve(int i, int j) {
		if (j == 9) {
			if (i == 8) {
				return true;
			}
			
			j = 0;
			i++;
		}
		
		GameLine line = getLine("row"+i);
		
		if (line.getValue(j) != 0)  {
			return solve(i, j+1);
		}

		for (int val = 1; val <= 9; ++val) {

			//System.out.println(String.format("Trying %s (%d,%d,%d) [%s]", line.id(), i, j, val, line.toString()));

			if (validate(i, j, val)) {
				
				line.putValue(j, val);
				
				//System.out.println(String.format("VALID %s (%d,%d,%d) [%s]", line.id(), i, j, val, line.toString()));
				
				if (solve(i, j+1)) {
					return true;
				}
			}
		}
		
		line.putValue(j,0); // reset on backtrack
		
		return false;
	}

	private boolean validate(int i, int j, int val) {
		GameLine row = getLine("row"+i);
		row.updateStatistics();
		
		if (row.assigned().contains(val)) {
			//System.out.println(String.format("FAIL: %s (%d, %d, %d)", row.id(), i, j, val));
			return false;
		}
		
		GameLine col = getLine("col"+j);
		col.updateStatistics();
		
		if (col.assigned().contains(val)) {
			//System.out.println(String.format("FAIL: %s (%d, %d, %d)", col.id(), i, j, val));
			return false;
		}
		
		GameLine grid = getLine("grid"+getGrid(i,j));
		grid.updateStatistics();
		
		if (grid.assigned().contains(val)) {
			//System.out.println(String.format("FAIL: %s (%d, %d, %d)", grid.id(), i, j, val));

			return false;
		}

		return true;
	}

	public int getGrid(int i, int j) {
		return ((i/3)*3)+(j/3);
	}

	public void generateSolution() {
		Collections.sort(lines);
		for (GameLine line : lines) {
			List<Integer> unfilled = line.empty();
			//List<Integer> unassigned = line.unassigned();
			
			System.out.println("Line:" + line.id() + " " + unfilled);
		}
	}

	public boolean complete() {
		for (GameLine line : lines) {
			if (!line.valid()) {
				return false;
			}
		}
		for (GameLine line : lines) {
			if (!line.complete()) {
				return false;
			}
		}
		return true;
	}


	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<9; i++) {
			GameLine line = getLine("row"+i);
			sb.append(line + "\n");
		}
		return sb.toString();
	}
	
	class GameLine implements Comparable<GameLine> {
		
		private String id;
		private int[] board;
		private int int0;
		private int int1;
		private int int2;
		private int int3;
		private int int4;
		private int int5;
		private int int6;
		private int int7;
		private int int8;

		private HashMap<Integer,Integer> counts = new HashMap<Integer,Integer>();
		private List<Integer> unassigned = new ArrayList<Integer>();
		private List<Integer> assigned = new ArrayList<Integer>();
		private List<Integer> empty = new ArrayList<Integer>();
		private int filled = 0;

		public GameLine (String id, int[] board, int int0, int int1, int int2, int int3, int int4, int int5, int int6, int int7, int int8) {
			this.id = id;
			this.board = board;
			this.int0 = int0;
			this.int1 = int1;
			this.int2 = int2;
			this.int3 = int3;
			this.int4 = int4;
			this.int5 = int5;
			this.int6 = int6;
			this.int7 = int7;
			this.int8 = int8;
		}

		public void init(int[] values) {
			for (int i=0; i<values.length; i++) {
				if (values[i] != 0) {
					putValue(i, values[i]);
				}
			}
		}

		public void putValue(int key, int value) {
			board[getIndex(key)] = value;
		}

		public int getValue(int key) {
			return board[getIndex(key)];
		}

		public void removeValue(int key, int value) {
			board[getIndex(key)] = 0;
		}

		public void updateStatistics() {
			filled = 0;
			counts.clear();
			empty.clear();
			assigned.clear();
			unassigned.clear();

			for (int i=0; i<9; i++) {
				int value = board[getIndex(i)];
				if (value != 0) {
					Integer count = counts.get(value);
					if (count != null) {
						counts.put(value, count);
					}
					else {
						counts.put(value, 1);
					}
					filled++;
				}
				else {
					empty.add(i);
				}
			}
			
			for (int i=1; i<=9; i++) {
				if (counts.containsKey(i)) {
					assigned.add(i);
				}
				else {
					unassigned.add(i);					
				}
			}

		}

		public int filled() {
			return filled;
		}

		private int getIndex(Integer key) {
			switch (key) {
			case 0: return int0;
			case 1: return int1;
			case 2: return int2;
			case 3: return int3;
			case 4: return int4;
			case 5: return int5;
			case 6: return int6;
			case 7: return int7;
			case 8: return int8;
			}
			return 0;
		}

		public boolean valid() {
			for (int i=0; i<9; i++) {				
				int value = board[getIndex(i)];
				if (!counts.containsKey(value) || counts.get(value) != 1) {
					return false;
				}
			}

			return true;
		}
		
		public boolean complete() {
			
			return valid() && counts.size() == 9;
		}

		public List<Integer> empty() {
			return empty;
		}

		public List<Integer> unassigned() {
			return unassigned;
		}

		public List<Integer> assigned() {
			return assigned;
		}


		public String id() {
			return id;
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (int i=0; i<9; i++) {
				if (board[getIndex(i)] != 0) {
					sb.append(board[getIndex(i)]);
				}
				else {
					sb.append(" ");
				}
			}
			return sb.toString();
		}

		@Override
		public int compareTo(GameLine o) {
		    if (this.filled() == o.filled()) return 0;
		    if (this.filled() < o.filled()) return 1;
		    if (this.filled() > o.filled()) return -1;
		    
			return 0;
		}
	}
}
