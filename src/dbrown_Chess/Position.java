package dbrown_Chess;

public class Position {

	private static final int ROW_LENGTH = 8;
	private static final int COL_LENGTH = 8;
	private int row;
	private int col;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Position(int row, int column){
		this.row = row;
		this.col = column;
	}
	public Position(char theRow, char theCol){
				
		this.row = 7 - (theRow -'1');
		this.col = theCol - 'a';		
	}
	
	public boolean isOnBoard(){		
		return row >= 0 && row < ROW_LENGTH && col >= 0 && col < COL_LENGTH;
	}
	
	
}
